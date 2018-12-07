package com.skyworth.sop.utils;


import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.regex.Pattern;

import org.apache.commons.lang.math.NumberUtils;

public class StringUtil
{

    private static String[] expectUrls = null;

    private static String[] mmUrls = null;

    private StringUtil()
    {
    }

    /**
     * 判断字符串是否是整数数字
     */
    public static boolean isDigtial(String str)
    {
        if (isEmpty(str))
        {
            return false;
        }
        return str.matches("\\d+");
    }

    /**
     * 判断当前访问的url是否是系统无须进行会话校验的url
     *
     * @param url 当前URL
     * @param exceptURL 从properties文件获取的配置信息
     * @return boolean [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isExceptUrl(String url, String exceptURL)
    {
        if (isEmpty(url) || isEmpty(exceptURL))
        {
            return false;
        }

        String[] excepts = exceptURL.split(",");
        expectUrls = new String[excepts.length];
        for (int i = 0; i < excepts.length; ++i)
        {
            expectUrls[i] = excepts[i].trim();
        }

        for (int i = 0; i < expectUrls.length; i++)
        {
            if (StringUtil.isEmpty(expectUrls[i]))
            {
                continue;
            }

            if (url.indexOf(expectUrls[i]) > -1)
            {
                return true;
            }
        }

        // 变更通知接口不鉴权
        if (-1 != url.indexOf("/notify/"))
        {
            return true;
        }

        // 图片不进行过滤器
        if (isPic(url))
        {
            return true;
        }

        return false;
    }

    public static boolean isPic(String url)
    {
        String urlStr = url.toLowerCase();

        return urlStr.endsWith(".png") || urlStr.endsWith(".jpg") || urlStr.endsWith(".gif");
    }

    /**
     * 允许null对象的trim方法
     *
     * @param str 给定的字符串
     * @return trim后的字符串
     */
    public static String trim(String str)
    {
        return str == null ? null : str.trim();
    }

    /**
     * 判断字符串是否为null对象或是空白字符
     */
    public static boolean isEmpty(String str)
    {
        return ((str == null) || (str.trim().length() == 0));
    }

    /**
     * 判断字符串是否bu为null对象或是空白字符
     */
    public static boolean isNotEmpty(String str)
    {
        return !isEmpty(str);
    }

    /**
     * getLength 返回非空字符串
     *
     * @param o 输入对象
     * @return string
     */
    public static String nvl(Object o)
    {
        return (null == o) ? "" : o.toString().trim();
    }

    /**
     * 若null对象或是空白字符，返回默认值，否则其trim结果
     *
     * @param str
     * @return [参数说明]
     */
    public static String getTrim(String str, String def)
    {
        if (str == null)
        {
            return def;
        }

        String t = str.trim();
        return (t.length() == 0) ? def : t;
    }

    /**
     * 判断当前访问的url是否是mm平台的url
     *
     * @param url
     * @return boolean [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isMMUrl(String url)
    {
        for (int i = 0; i < mmUrls.length; i++)
        {
            // TODO 要处理下，ueswap中没有viewbook.jsp。
            if (url.contains(mmUrls[i]) && !url.contains("viewbook.jsp"))
            {
                return true;
            }
        }

        return false;
    }

    /**
     * 取子串
     *
     * @param str
     * @param begin
     * @param end
     * @author zhaoxinwei
     */
    public static String subString(String str, int begin, int end)
    {
        if (StringUtil.isEmpty(str))
        {
            return str;
        }

        int b = Math.max(begin, 0);
        int e = Math.min(end, str.length());
        return str.substring(b, e);
    }

    /**
     * 替换反斜线"\"为斜线"/"
     */
    public static String replaceBacklash(String str)
    {
        if (isEmpty(str))
        {
            return "";
        }
        else
        {
            return str.replace("\\", "/");
        }
    }

    /**
     * 将&替换为&amp;
     *
     * @param text
     * @see [类、类#方法、类#成员]
     */
    public static String replace2amp(String text)
    {
        return text2Html(text);
    }

    /**
     * 查找替换字符串中的子串。
     *
     * @param text 待处理字符串。
     * @param find 待替换的子串。
     * @param replace 替换成的子串。
     * @return 返回text替换后的结果。
     */
    public static String replace(String text, String find, String replace)
    {
        if (text == null || find == null || replace == null)
        {
            return text;
        }
        int findLen = find.length();
        int textLen = text.length();
        if (textLen == 0 || findLen == 0)
        {
            return text;
        }
        StringBuffer sb = new StringBuffer(256);
        int begin = 0; // 下次检索开始的位置
        int i = text.indexOf(find); // 找到的子串位置
        while (i != -1)
        {
            sb.append(text.substring(begin, i));
            sb.append(replace);
            begin = i + findLen;
            i = text.indexOf(find, begin);
        }
        if (begin < textLen)
        {
            sb.append(text.substring(begin));
        }
        return sb.toString();
    }

    /**
     * 对字符串特殊字符进行过滤 <功能详细描述>
     *
     * @param request
     * @param str
     * @return String [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String replaceChar(String str)
    {
        // 当输入为null时，只进行空字符串转换
        if (null == str)
        {
            str = "";
        }
        str = replace(str, "&", "&amp;");
        str = replace(str, "'", "&apos;");
        str = replace(str, "<<", "&lt;&lt;");
        str = replace(str, ">>", "&gt;&gt;");
        return str;
    }

    /**
     * 特殊字符转义，文本转为html
     *
     * @param text
     * @return String [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String text2Html(String text)
    {
        text = replace(text, "&amp;", "&");
        text = replace(text, "&lt;", "<");
        text = replace(text, "&gt;", ">");
        text = replace(text, "&quot;", "\"");
        text = replace(text, "&apos;", "'");

        text = replace(text, "&", "&amp;");
        text = replace(text, "<", "&lt;");
        text = replace(text, ">", "&gt;");
        text = replace(text, "\"", "&quot;");
        text = replace(text, "'", "&apos;");

        return text;
    }

    /**
     * 特殊字符转义，html转为文本
     *
     * @param text
     * @return String [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String html2Text(String text)
    {

        text = replace(text, "&lt;", "<");
        text = replace(text, "&gt;", ">");
        text = replace(text, "&amp;", "&");
        text = replace(text, "&quot;", "\"");
        text = replace(text, "&apos;", "'");
        //text = replace(text, "&nbsp;", " ");
        //text = replace(text, "&cent;", "￠");
        //text = replace(text, "&pound;", "£");
        //text = replace(text, "&yen;", "¥");
        //text = replace(text, "&euro;", "€");
        //text = replace(text, "&sect;", "§");
        //text = replace(text, "&copy;", "©");
        //text = replace(text, "&reg;", "®");
        //text = replace(text, "&trade;", "™");
        //text = replace(text, "&times;", "×");
        //text = replace(text, "&divide;", "÷");
        return text;
    }

    /**
     * replace$ 返回字符串，将一个$更改为两个$
     *
     * @param instr 输入字符串
     * @return String
     */
    private static String replace$(String instr)
    {
        StringBuffer sb = new StringBuffer(instr);
        int place = sb.indexOf("$");
        while (place >= 0)
        {
            sb.replace(place, place + 1, "$$");
            place = sb.indexOf("$", place + 2);
        }
        return sb.toString();
    }

    /**
     * 字符串按字节截取（获取到半个中文时，抛弃该中文）
     *
     * 当原字符串比截取的长度要短或相等时，返回原字符串 当需要截取字符串时，如果省略符号长度大于要截取的长度时，将返回空值 如果截取后的内容为空，那么也返回空值，不携带省略号
     * 如果截取的是汉字，如果只能截取到半个汉字，则将不获取该汉字字符
     *
     * @param str 要截取的字符串
     * @param len 截取的长度
     * @param elide 省略号
     * @return String [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String getStrByLengthForShort(String str, int len, String elide)
    {
        if (str == null)
        {
            return "";
        }

        byte[] strByte = str.getBytes();
        int strLen = strByte.length;

        if (len >= strLen)
        { // 不需要用到省略号
            return str;
        }

        // 需要用到省略号
        elide = elide == null ? "" : elide;
        int elideLen = elide.getBytes().length;

        if (len <= elideLen)
        {
            return "";
        }
        len = len - elideLen;

        // 截取时，涉及到的汉字数目(一个汉字占2个)
        int count = 0;
        for (int i = 0; i < len; i++)
        {
            int value = (int)strByte[i];
            if (value < 0)
            {
                count++;
            }
        }
        if (count % 2 != 0)
        {
            len = len - 1;
        }
        String subString = new String(strByte, 0, len);

        subString = StringUtil.isEmpty(subString) ? "" : subString + elide;

        return subString;
    }

    /**
     * 判断字符串是否与数组中的某个参数相等
     */
    public static boolean matches(String base, String[] matches)
    {
        if (null == matches || 0 == matches.length)
        {
            return false;
        }
        else
        {
            for (int i = 0; i < matches.length; i++)
            {
                if (matches[i].equals(base))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * String to float
     *
     * @param s
     * @param def
     * @return float [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static float toFloat(String s, float def)
    {
        float f = def;

        try
        {
            f = Float.parseFloat(s);
        }
        catch (Exception e)
        {
            f = def;
        }
        return f;
    }

    /**
     * String to int <功能详细描述>
     *
     * @param s
     * @param def
     * @return int [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static int toInt(String s, int def)
    {
        int value = def;

        try
        {
            value = Integer.parseInt(s);
        }
        catch (Exception e)
        {
            value = def;
        }

        return value;
    }

    /**
     * String to double <功能详细描述>
     *
     * @param s
     * @param def
     * @return int [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static double toDouble(String s, double def)
    {
        double value = def;

        try
        {
            value = Double.parseDouble(s);
        }
        catch (Exception e)
        {
            value = def;
        }

        return value;
    }

    public static String getSum(String s1, String s2)
    {
        double s3 = toDouble(s1, 0);
        double s4 = toDouble(s2, 0);
        return String.valueOf(s3 + s4);
    }

    public static String getSub(String s1, String s2)
    {
        double s3 = toDouble(s1, 0);
        double s4 = toDouble(s2, 0);
        return String.valueOf(s3 - s4);
    }

    /**
     * String to Long <功能详细描述>
     *
     * @param s
     * @param def
     * @return int [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static Long toLong(String s, long def)
    {
        long value = def;

        try
        {
            value = Long.parseLong(s);
        }
        catch (Exception e)
        {
            value = def;
        }

        return value;
    }

    /**
     * 取得从0开始长度为length的子字符串，如果str的长度小于length的长度则取得整个字符串 <功能详细描述>
     *
     * @param str
     * @param length
     * @return String [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @author lKF13186 2009-7-23
     * @see [类、类#方法、类#成员]
     */
    public static String getSubstr(String str, int length)
    {
        if (null == str)
        {
            return "";
        }
        else
        {
            return (str.length() > length) ? (str.substring(0, length) + "...") : str;
        }

    }

    /**
     * 删除小数点后面的0,例如：5.40 -> 5.4 ; 5.00->5 ; 5.04 不变
     */
    public static String removeZeroAfterDecimalPoint(String data)
    {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(10);
        return nf.format(Double.valueOf(data));
    }

    /**
     * 去掉两位的打折数字的末位0
     *
     * @param discount
     * @return String [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String convertDiscount(String discount)
    {
        if (discount == null || "".equals(discount.trim()))
        {
            return "";
        }
        else if (discount.endsWith("0"))
        {
            return discount.substring(0, discount.length() - 1);
        }
        else
        {
            return discount;
        }
    }

    /**
     * 将字符串中的指定位置的字符替换
     *
     * @param s 原始字符串
     * @param begin 起始位置
     * @param end 结束位置
     * @param c 替换字符
     * @see [类、类#方法、类#成员]
     */
    public static String replacs(String s, int begin, int end, String c)
    {
        if (null != s)
        {
            int len = s.length();
            if ((end > begin) && (len > begin))
            {
                if (len < end)
                {
                    end = len;
                }
                if (begin < 0)
                {
                    begin = 0;
                }
                StringBuffer sb = new StringBuffer(s.substring(0, begin));
                for (; begin < end; begin++)
                {
                    sb.append(c);
                }
                sb.append(s.substring(end));
                s = sb.toString();
            }
        }
        else
        {
            s = "";
        }
        return s;
    }

    /**
     * 分
     *
     * @param s
     * @param def
     * @return String [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String fenToYuan(String s, float def)
    {
        // 赠送页面费用格式0.0--->0.00
        float fen = StringUtil.toFloat(s, def);
        String sFen = (int)Math.floor(fen) + "";
        int len = sFen.length();

        String yuan;
        if (len == 1)
        {
            yuan = "0.0" + sFen;
        }
        else if (len == 2)
        {
            yuan = "0." + sFen;
        }
        else
        {
            yuan = sFen.substring(0, len - 2) + '.' + sFen.substring(len - 2);
        }

        return (fen < 0) ? ('-' + yuan) : yuan;
    }

    /**
     * 获取字符串长度
     *
     * @param string
     * @return String [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static int getStrLenth(String str)
    {
        if (StringUtil.isEmpty(str))
        {
            return 0;
        }
        int strLength = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) > 255)
            {
                strLength += 2;
            }
            else
            {
                strLength += 1;
            }
        }
        return strLength;
    }

    /**
     * 判断两字符串是否相等
     *
     * @param str1
     * @param str2
     * @return boolean [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isEq(String str1, String str2)
    {
        if (str1 == null)
        {
            return str2 == null;
        }
        return str1.equals(str2);
    }


    /**
     * * <一句话功能简述>以默认字符串代替已有字符串<功能详细描述>
     *
     * @param tempStr 目标字符串
     * @param def 默认字符串
     * @return [参数说明]
     */
    public static String nvl2(String tempStr, String def)
    {
        if (StringUtil.isEmpty(tempStr))
        {
            return def == null ? "" : def.trim();
        }
        else
        {
            return tempStr.trim();
        }
    }

    /**
     * 特殊字符转义，文本转为html
     *
     * @param text
     * @return String [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String text2HtmlToSend(String text)
    {
        text = replace(text, "&amp;", "&");
        text = replace(text, "&lt;", "<");
        text = replace(text, "&gt;", ">");
        text = replace(text, "&quot;", "\"");
        text = replace(text, "&apos;", "'");
        return text;
    }

    /**
     * 对特殊字符进行转义 <功能详细描述>
     *
     * @param text
     * @see [类、类#方法、类#成员]
     */
    public static String textchange(String text)
    {
        /*
         * if (log.isDebugEnable()) { log.debug("ENTER StringTools.textchange(String text) text:" + text); }
         */
        String str1 = text.replace("&nbsp;", "&#160;");

        str1 = str1.replaceAll("&lt;", "&#60;");
        str1 = str1.replaceAll("&gt;", "&#62;");
        str1 = str1.replaceAll("&quot;", "&#34;");
        str1 = str1.replaceAll("&apos;", "&#39;");

        str1 = str1.replaceAll("￠", "&#162;");
        str1 = str1.replaceAll("&cent;", "&#162;");
        str1 = str1.replaceAll("£", "&#163;");
        str1 = str1.replaceAll("&pound;", "&#163;");
        str1 = str1.replaceAll("¥", "&#165;");
        str1 = str1.replaceAll("&yen;", "&#165;");
        str1 = str1.replaceAll("€", "&#8364;");
        str1 = str1.replaceAll("&euro;", "&#8364;");
        str1 = str1.replaceAll("§", "&#167;");
        str1 = str1.replaceAll("&sect;", "&#167;");
        str1 = str1.replaceAll("©", "&#169;");
        str1 = str1.replaceAll("&copy;", "&#169;");
        str1 = str1.replaceAll("®", "&#174;");
        str1 = str1.replaceAll("&reg;", "&#174;");
        str1 = str1.replaceAll("™", "&#8482;");
        str1 = str1.replaceAll("&trade;", "&#8482;");
        str1 = str1.replaceAll("×", "&#215;");
        str1 = str1.replaceAll("&times;", "&#215;");
        str1 = str1.replaceAll("÷", "&#247;");
        str1 = str1.replaceAll("&divide;", "&#247;");
        str1 = str1.replaceAll("&amp;", "&#38;");

        str1 = str1.replaceAll("&", "&#38;");

        str1 = str1.replaceAll("&#38;#38;", "&#38;");
        str1 = str1.replaceAll("&#38;#160;", "&#160;");
        str1 = str1.replaceAll("&#38;#60;", "&#60;");
        str1 = str1.replaceAll("&#38;#62;", "&#62;");
        str1 = str1.replaceAll("&#38;#38;", "&#38;");
        str1 = str1.replaceAll("&#38;#34;", "&#34;");
        str1 = str1.replaceAll("&#38;#39;", "&#39;");
        str1 = str1.replaceAll("&#38;#162;", "&#162;");
        str1 = str1.replaceAll("&#38;#163;", "&#163;");
        str1 = str1.replaceAll("&#38;#165;", "&#165;");
        str1 = str1.replaceAll("&#38;#8364;", "&#8364;");
        str1 = str1.replaceAll("&#38;#167;", "&#167;");
        str1 = str1.replaceAll("&#38;#169;", "&#169;");
        str1 = str1.replaceAll("&#38;#174;", "&#174;");
        str1 = str1.replaceAll("&#38;#8482;", "&#8482;");
        str1 = str1.replaceAll("&#38;#215;", "&#215;");
        str1 = str1.replaceAll("&#38;#247;", "&#247;");
        /*
         * if (log.isDebugEnable()) { log.debug("EXET StringTools.textchange(Stirng text) text:" + str1); }
         */
        return str1;
    }

    /**
     * 话单专用话单长度截取及特殊字符替换方法
     *
     * @param src
     * @param length
     * @author yWX279683
     */
    public static String CdrSubString(String src, int length)
    {
        if (isEmpty(src))
        {
            return src;
        }
        if (src.length() <= length)
        {
            return src.replace("|", "#");
        }
        src = src.substring(0, length);
        return src.replace("|", "#");
    }

    /**
     * 获取字符串中特定字符串个数
     *
     * @param str1 原始字符串
     * @param str2 需要查找的字符串
     * @author jWX239620
     */
    public static int countStr(String str1, String str2)
    {
        int cnt = 0;
        int offset = 0;
        while ((offset = str1.indexOf(str2, offset)) != -1)
        {
            offset = offset + str2.length();
            cnt++;
        }
        return cnt;
    }

    /**
     * 将字符串转换为BigDecimal对象，如果转换异常，返回默认值
     *
     * @param string
     * @param def
     * @author yWX280128
     */
    public static BigDecimal toBigDecimal(String string, String def)
    {
        BigDecimal value = null;

        try
        {
            value = new BigDecimal(string);
        }
        catch (Exception e)
        {
            value = new BigDecimal(def);
        }

        return value;
    }

    /**
     * 返回两个高精度字符串差值，如果字符串转换失败，默认值为0
     *
     * @param string1
     * @param string2
     * @author yWX280128
     */
    public static double getSubByBD(String string1, String string2)
    {
        BigDecimal first = toBigDecimal(string1, "0");
        BigDecimal second = toBigDecimal(string2, "0");

        return first.subtract(second).doubleValue();
    }

    /**
     * 隐藏手机号的4-7位
     *
     * @param str
     * @author yWX327087
     */
    public static String getHidenStr(String str)
    {
        if (StringUtil.isEmpty(str))
        {
            return "";
        }

        // 非手机号或邮箱不做隐藏
        if (!(str.matches("^1[0-9]{10}$")))
        {
            return str;
        }

        int length = str.length();
        String hidenStr = "";
        String str1 = "";
        String str2 = "";

        // 字符串长度小于3位直接返回
        if (length < 3)
        {
            return str;
        }
        // 字符串长度大于3位小于8位
        else if (length < 8)
        {
            str1 = str.substring(0, 3);

            for (int i = 3; i < length; i++)
            {
                str2 = str2 + "*";
            }

            hidenStr = str1 + str2;
        }
        // 字符串长度大于等于8位
        else
        {
            str1 = str.substring(0, 3);
            str2 = str.substring(7, length);
            hidenStr = str1 + "****" + str2;
        }

        return hidenStr;
    }

    /**
     * 动态替换url中的特殊字符
     *
     * @param url
     * @param token
     * @param nodeId
     * @param useriD
     * @return url
     * @author jWX239620
     */
    public static String getReplace(String url, String nid, String tid, String cid, String xid, String cat)
    {
        if (StringUtil.isEmpty(url))
        {
            return null;
        }
        else if (StringUtil.isEmpty(nid))
        {
            nid = "";
        }
        else if (StringUtil.isEmpty(tid))
        {
            tid = "";
        }
        else if (StringUtil.isEmpty(cid))
        {
            cid = "";
        }
        else if (StringUtil.isEmpty(xid))
        {
            xid = "";
        }
        else if (StringUtil.isEmpty(cat))
        {
            cat = "";
        }
        String neUrl = url.replace("{tid}", tid);
        String lurl = neUrl.replace("{nid}", nid);
        String aaurl = lurl.replace("{xid}", xid);
        String cpurl = aaurl.replace("{cid}", cid);
        String caturl = cpurl.replace("{cat}", cat);
        return caturl;

    }

    /**
     * BR001146_zhouxin_将文本中空格统一转换为&nbsp;使页面展示实际空格数 <功能详细描述>
     *
     * @param recommendation
     * @see [类、类#方法、类#成员]
     */
    public static String space2nbsp(String text)
    {
        text = replace(text, "&nbsp;", " ");
        text = replace(text, " ", "&nbsp;");
        return text;
    }

    /**
     * 拼接字符串（支持N参数拼接）
     *
     * @param array
     */
    public static String append2String(String... arrays)
    {
        StringBuilder sb = new StringBuilder();
        for (String array : arrays)
        {
            sb.append(array);
        }

        return sb.toString();
    }

    public static String getString(String org, String def)
    {
        return isEmpty(org) ? def : org;
    }

    /**
     * 校验IP地址
     *
     * @author jiangyongjie
     * @version [版本号, 2017年2月15日]
     * @see [类、类#方法、类#成员]
     */
    public static boolean checkUserIp(String userip)
    {
        String isMacthIpRule =
            "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

        return Pattern.matches(isMacthIpRule, userip);
    }

    /**
     * 对字符串特殊字符进行过滤 <功能详细描述>
     *
     * @param request
     * @param str
     * @return String [返回类型说明]
     * @throws throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String replaceSpecialChar(String str)
    {
        // Begin modify by hejianli 101670 at 2012-06-15 for IRD-24077
        // 当输入为null时，只进行空字符串转换
        if (null == str)
        {
            str = "";
        }
        str = StringUtil.text2Html(str);
        // End modify by hejianli 101670 at 2012-06-15 for IRD-24077

        str = StringUtil.replace$(str);
        // 脚本中的换行替换为页面转换的换行
        str = str.replace("{BR}", "<br/>");
        // 替换为html换行标签
        str = str.replace("\r\n", "<br/>");
        return str;
    }

    /**
     * 将空字符串转换为空格字符串
     *
     * @param s
     * @author fengjiangtao
     */
    public static String e2s(String s)
    {
        return isEmpty(s) ? " " : s;
    }

    /**
     * 将空字符串转换为空格字符串
     *
     * @param s
     * @author fengjiangtao
     */
    public static String empty2Space(String s)
    {
        return isEmpty(s) ? " " : s;
    }

    /**
     * 判断指定的对象是否为空
     *
     * @param obj
     * @author yuhaihan
     */
    public static boolean isObjectEmpty(Object obj)
    {
        if (null == obj)
        {
            return true;
        }
        return false;
    }

    public static boolean isObjectNotEmpty(Object obj)
    {
        return !isObjectEmpty(obj);
    }

    public static boolean isLessEqual(String str, String ymd)
    {
        int num = str.compareTo(ymd);
        return num <= 0;
    }

    /**
     * 将字符串转换为正整数，包含0
     *
     * @param str
     * @param def
     * @author fengjiangtao
     */
    public static int toPositiveInt(String str, int def)
    {
        int tmpInt = NumberUtils.toInt(str, def);

        if (tmpInt < 1)
        {
            if (def >= 0)
            {
                return def;
            }
            else
            {
                return 0;
            }
        }

        return tmpInt;

    }

    /**
     * 将数组的内容拼接成字符串输出
     *
     * @param objectArr 数组对象
     * @return java.lang.String
     * @author fengjiangtao
     */
    public static String arrayToString(Object[] objectArr)
    {
        if (Util.isEmpty(objectArr))
        {
            return null;
        }
        return Arrays.asList(objectArr).toString();
    }

    /**
     * 获取一个字符串中中文的个数(包含中文标点)
     *
     * @param str 要处理的字符串
     * @return int
     * @author fengjiangtao
     */
    public static int getChineseNum(String str)
    {
        int count = 0;
        if (isEmpty(str))
        {
            return count;
        }
        char[] chars = str.toCharArray();
        for (char c : chars)
        {
            if (isChineseByScript(c) || isChinesePunctuation(c))
            {
                count++;
            }
        }
        return count;
    }

    /**
     * 判断字符是否是汉字
     *
     * @param c 要判断的字符
     * @return boolean
     * @author fengjiangtao
     */
    public static boolean isChineseByScript(char c)
    {
        Character.UnicodeScript sc = Character.UnicodeScript.of(c);
        if (sc == Character.UnicodeScript.HAN)
        {
            return true;
        }
        return false;
    }

    /**
     * 判断字符是否是中文标点符号
     *
     * @param c 要判断的字符
     * @return boolean
     * @author fengjiangtao
     */
    public static boolean isChinesePunctuation(char c)
    {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
            || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
            || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
            || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
            || ub == Character.UnicodeBlock.VERTICAL_FORMS)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * 添加标签
     * @param labelText
     * @param labelName
     * @param labelType
     * @author qiaoyuhui
     * @return
     */
    public static String addLable(String labelText,String labelName,String labelType) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("<").append(labelName);
    	if(!isEmpty(labelType)) {
    		sb.append("_").append(labelType.toString());
    	}
    	sb.append(">").append(labelText).append("</").append(labelName);
    	if(!isEmpty(labelType)) {
    		sb.append("_").append(labelType.toString());
    	}
    	sb.append(">");
    	return sb.toString();
    }
}
