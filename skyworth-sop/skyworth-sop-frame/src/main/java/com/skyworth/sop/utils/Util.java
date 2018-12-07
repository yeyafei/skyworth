package com.skyworth.sop.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Util
{

    public final static String LINE_SEP = System.getProperty("line.separator");

    public final static String FILE_SEP = System.getProperty("file.separator");


    /**
     * 防止外部实例化该类
     */
    private Util()
    {
    }

    /**
     * 检验字符串的内容是否是在整型范围内的非负整数 <功能详细描述>
     *
     * @param str
     * @return [参数说明]
     *
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isNotNegativeInt(String str)
    {
        int checkInt;
        try
        {
            checkInt = Integer.parseInt(str);
            if (0 > checkInt)
            {
                return false;
            }
            return true;
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 检验字符串的内容是否是在整形范围内的数字 <功能详细描述>
     *
     * @param str
     * @return [参数说明]
     *
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isLong(String str)
    {
        try
        {
            Long.parseLong(str);
            return true;
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 检验字符串的内容是否是浮点格式 <功能详细描述>
     *
     * @param str
     * @return [参数说明]
     *
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isFloat(String str)
    {
        try
        {
            Float.parseFloat(str);
            return true;
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 给字符串去掉空格 <功能详细描述>
     *
     * @param arg
     * @return [参数说明]
     *
     * @return String [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static String trim(String arg)
    {
        if (null == arg)
        {
            return "";
        }
        else
        {
            return arg.trim();
        }
    }

    /**
     * 检查字符串是否为空，字符串为null，或者长度为0都认为为空 <功能详细描述>
     *
     * @param str
     * @return [参数说明]
     *
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isEmpty(String str)
    {
        if (null == str)
        {
            return true;
        }

        if (0 == str.trim().length())
        {
            return true;
        }

        return false;
    }

    public static boolean isNotEmpty(String str)
    {
        return !isEmpty(str);
    }

    /**
     * 判断指定的对象是否为空
     *
     * @param obj
     * @return [参数说明]
     *
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isEmpty(Object obj)
    {
        if (null == obj)
        {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(Object obj)
    {
        return !isEmpty(obj);
    }

    /**
     * 判断指定的对象是否为空
     *
     * @return [参数说明]
     *
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Map map)
    {
        if ((null == map) || (map.isEmpty()))
        {
            return true;
        }

        return false;
    }

    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(Map map)
    {
        return !isEmpty(map);
    }

    /**
     * 判断指定的字符串数组是否为空或长度为0 <功能详细描述>
     *
     * @param strArr 字符串数组
     * @return [参数说明]
     *
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isEmpty(String[] strArr)
    {
        if ((null == strArr) || (strArr.length < 1))
        {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String[] strArr)
    {
        return !isEmpty(strArr);
    }

    /**
     * 判断指定的对象数组是否为空
     *
     * @param objArr 对象数组
     * @return [参数说明]
     *
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isEmpty(Object[] objArr)
    {
        if ((null == objArr) || (objArr.length < 1))
        {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(Object[] objArr)
    {
        return !isEmpty(objArr);
    }

    /**
     * 判断指定的对象列表是否为空
     *
     * @param lst 指定的对象列表
     * @return [参数说明]
     *
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isEmpty(List<? extends Object> lst)
    {
        if ((null == lst) || (lst.isEmpty()))
        {
            return true;
        }
        return false;
    }

    /**
     * 判断指定的对象列表是否为空
     *
     * @param lst 指定的对象列表
     * @return [参数说明]
     *
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isNotEmpty(List<? extends Object> lst)
    {
        return !isEmpty(lst);
    }

    /**
     * 判断指定的对象集合是否为空
     *
     * @param set 指定的对象列表
     * @return [参数说明]
     *
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isEmpty(Set<? extends Object> set)
    {
        if ((null == set) || (set.isEmpty()))
        {
            return true;
        }
        return false;
    }

    /**
     * 判断指定的对象集合是否为空
     *
     * @param set 指定的对象列表
     * @return [参数说明]
     *
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isNotEmpty(Set<? extends Object> set)
    {
        return !isEmpty(set);
    }

    /**
     * 检查字符串是否为空，字符串为null，或者长度为0都认为为空 <功能详细描述>
     *
     * @param str
     * @return [参数说明]
     *
     * @return boolean [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static boolean isInt(String str)
    {
        if (isEmpty(str))
        {
            return false;
        }

        try
        {
            Integer.parseInt(str.trim());
        }
        catch (NumberFormatException ex)
        {
            return false;
        }

        return true;
    }

    /**
     * 计算指定字符串的MD5摘要
     *
     * @param strSrc 指定的原字符串
     * @return 计算后的字节数组
     */
    public static byte[] getMD5(String strSrc)
    {
        if (null == strSrc)
        {
            return null;
        }

        byte[] bArrRst = null;// 返回的字节数组
        try
        {
            byte[] passwdtmp = strSrc.getBytes("UTF-8");
            MessageDigest md5 = MessageDigest.getInstance("MD5");// MD5
            md5.update(passwdtmp, 0, passwdtmp.length);
            bArrRst = md5.digest();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return bArrRst;
    }

    /**
     * 返回对象的字符形式 如果对象为null，则返回""
     *
     * @param o 输入对象
     * @return string
     *
     */
    public static String nvl(Object o)
    {
        return (null == o) ? "" : o.toString().trim();
    }

    /**
     * 截取Map的部分内容 LinkedHashMap是有顺序的map，所以可以按添加顺序截取
     *
     * @param linkedHashMap
     * @param start 开始下标，从0开始
     * @param size 要截取的个数
     * @param exceptKeys 截取时，不会获取的对象
     * @return [参数说明]
     *
     * @return LinkedHashMap<K,V> [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public static <K, V> LinkedHashMap<K, V> copyMap(LinkedHashMap<K, V> linkedHashMap, int start, int size,
        @SuppressWarnings("unchecked") K... exceptKeys)
    {
        Set<K> exceptKey = new HashSet<K>();
        Collections.addAll(exceptKey, exceptKeys);

        LinkedHashMap<K, V> subMap = new LinkedHashMap<K, V>();
        if (null != linkedHashMap)
        {
            int length = linkedHashMap.size();
            if (start < length)
            {
                subMap = new LinkedHashMap<K, V>();
                Set<Map.Entry<K, V>> entrys = linkedHashMap.entrySet();
                int index = 0; // map下标
                int curSize = 0;
                for (Map.Entry<K, V> en : entrys)
                {
                    if (index >= start)
                    {
                        K key = en.getKey();
                        // 排除不要的对象
                        if (!exceptKey.contains(key))
                        {
                            if (curSize < size)
                            {
                                curSize++;
                                subMap.put(en.getKey(), en.getValue());
                            }
                            else
                            { // 数量已全，退出循环
                                break;
                            }
                        }
                    }
                    index++;
                }
            }
        }
        return subMap;
    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    public static List mapToList(Map map)
    {
        List ls = new ArrayList();
        Set<String> key = map.keySet();
        for (Iterator it = key.iterator(); it.hasNext(); )
        {
            String s = (String)it.next();
            ls.add(map.get(s));
        }
        return ls;
    }


    /**
     * <一句话功能简述> 给有分页功能函数调用，取加载缓存中所有的List后，截取需要的记录
     *
     * @param pageNo
     * @param pageSize
     * @param list 缓存中所有的List记录
     * @param recordCount 记录总数（数据库中全部记录）
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static <T> List<T> getSubList(int pageNo, int pageSize, int recordCount, List<T> list)
    {
        int start = (pageNo - 1) * pageSize + 1;
        int fromIdex = 0;
        int toIndex = 0;

        if (recordCount >= start && recordCount >= start + pageSize)
        {
            fromIdex = start - 1;
            toIndex = start + pageSize - 1;
        }
        else if (recordCount >= start && recordCount < start + pageSize)
        {
            fromIdex = start - 1;
            toIndex = recordCount;
        }
        else if (recordCount < start)
        {
                    /* 返回最后一页信息 */
            int pageCount =
                (recordCount % pageSize == 0) ? (recordCount / pageSize) : (recordCount / pageSize + 1);
            if (pageCount < 1)
            {
                return null;
            }
            fromIdex = (pageCount - 1) * pageSize;
            toIndex = recordCount;
        }
        list = list.subList(fromIdex, toIndex);
        /*
         * if (log.isDebugEnable()) { log.debug("list.size()=" + list.size() + "||pageNo=" + pageNo + "||pageSize=" +
         * pageSize + "||recordCount=" + recordCount); }
         */
        if (Util.isEmpty(list))
        {
            return null;
        }
        return list;
    }



    /**
     *
     * 根据ip地址获取其对应的10进制数值,
     *
     * @author yWX279683
     * @param ipAddress
     * @return result 返回0表示ip地址非法或者是ipv6
     * @throws Exception
     */
    public static long calcIpNum(String ipAddress)
    {

        long result = 0;
        String[] ipList = (ipAddress.split("\\."));

        // 若ip地址分隔后不是4，说明地址非法或者是ipv6，这里暂时不处理ipv6的情况，默认直接返回0
        if (ipList.length != 4)
        {
            return 0;
        }

        for (int i = 0; i < ipList.length; i++)
        {
            int num;
            try
            {
                num = Integer.valueOf(ipList[i]);
            }
            catch (Exception e)
            {
                return 0;
            }

            // ip的每个数值若不是[0,255],说明地址非法
            if (num < 0 || num > 255)
            {
                return 0;
            }
            result |= (long)num << (ipList.length - 1 - i) * 8;
        }

        return result;
    }

    /**
     * 获取屏蔽的手机号码
     *
     * @param msisdn 原有手机号码
     * @return
     * @see [类、类#方法、类#成员]
     */

    public static String getShieldMsisdn(String msisdn)
    {
        return StringUtil.replacs(msisdn, 3, 7, "*");
    }

    /**
     * 获取屏蔽的邮箱号码，邮箱账号第三位和@之间隐藏
     *
     * @param mail 邮箱号码
     * @return 经过屏蔽的邮箱号码
     */
    public static String getShieldMail(String mail)
    {
        String[] mailArray = mail.split("@");
        String mailNum = mailArray[0];
        StringBuffer sb = null;
        if (mailNum.length() > 3)
        {
            sb = new StringBuffer(mailNum.substring(0, 3));
        }
        else
        {
            sb = new StringBuffer(mailNum);
        }
        sb.append("***@");
        sb.append(mailArray[1]);
        return sb.toString();
    }

    /**
     * 得到形如： 1->Ab*** 123->Abc*** 1234-> Abc*** 1234567 ->123***7 的屏蔽号码
     *
     * @return 除邮箱和手机外经过屏蔽的其他的支付宝号码
     */
    public static String getOtherShieldAlipayNum(String alipayNum)
    {
        StringBuffer sb = null;
        if (alipayNum.length() > 6)
        {
            sb = new StringBuffer(alipayNum.substring(0, 3));
            sb.append("***");
            sb.append(alipayNum.substring(6));
        }
        else if (alipayNum.length() > 3)
        {
            sb = new StringBuffer(alipayNum.substring(0, 3));
            sb.append("***");
        }
        else
        {
            sb = new StringBuffer(alipayNum);
            sb.append("***");
        }
        return sb.toString();
    }


    /**
     * 返回参数的字符串形式
     *
     * @param obj
     * @return String
     */
    public static String toString(Object obj)
    {
        if (null == obj || "".equals(obj))
        {
            return "";
        }
        String s = "";
        try
        {
            s = String.valueOf(obj);
        }
        catch (Exception e)
        {
            return "";
        }

        return s;
    }


    /**
     * map里有空值
     *
     *
     * @author wangyiwen
     * @return
     */
    public static boolean mapHaveNone(Map<String, String> map)
    {
        if (Util.isNotEmpty(map))
        {
            for (String key : map.keySet())
            {
                if (Util.isEmpty(map.get(key)))
                {
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * BR002304_zhouxin_咪咕币余额查询与过期提醒,解析“type=method”格式 <功能详细描述>
     *
     * @return
     * @see [类、类#方法、类#成员]
     */
    /*
     * public static String getInterfaceName(String type, String[] methods) { String interfaceName = null; if
     * (StringTools.isEmpty(type) || isEmpty(methods)) { return interfaceName; } for (String s : methods) { String[]
     * keyAndValue = s.split("="); if (keyAndValue.length == 2 && StringTools.isEq(keyAndValue[0], type)) {
     * interfaceName = keyAndValue[1]; break; } }
     * 
     * return interfaceName; }
     */

    public static int getRandom(int num)
    {
        Random r = new Random();
        return r.nextInt(num) + 1;
    }


    
    /**
     * 判断对应key在map中的值是否为空
     * 
     * @author zhouye
     * @version [UES135, 2018年1月24日]
     * @since [BR005207]
     * @param map
     * @param key
     * @return
     */
    public static boolean isNotEmptyinMap(Map<String, String> map, String key)
    {
        String endTime = map.get(key);
        if (StringUtil.isNotEmpty(endTime))
        {
            return true;
        }
        
        return false;
    }
    
    
 
}