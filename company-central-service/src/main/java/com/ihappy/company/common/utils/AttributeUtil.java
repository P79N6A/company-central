package com.ihappy.company.common.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class AttributeUtil {
    static final String SP = ";";
    static final String SSP = ":";

    static final String R_SP = "#3A";
    static final String R_SSP = "#3B";

    /**
     * 通过Map转换成String
     * @param attrs
     * @return
     */
    public static final String toString(Map<String, String> attrs) {
        StringBuilder sb = new StringBuilder();
        if (null != attrs && !attrs.isEmpty()) {
            sb.append(SP);
            Iterator<Map.Entry<String, String>> iterator = attrs.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> entry = iterator.next();
                String key = entry.getKey();
                String val = entry.getValue();
                if (StringUtils.isNotEmpty(val)) {
                    sb.append(encode(key)).append(SSP).append(encode(val)).append(SP);
                }
            }
        }
        return sb.toString();
    }

    public static final String toString(String key, String val) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotEmpty(key) && StringUtils.isNotEmpty(val)) {
            sb.append(SP);
            sb.append(encode(key)).append(SSP).append(encode(val));
            sb.append(SP);
        }
        return sb.toString();
    }

    /**
     * 通过字符串解析成attributes
     * @param str
     * @return
     */
    public static final Map<String, String> fromString(String str) {
        Map<String, String> attrs = new HashMap<String, String>();
        if (StringUtils.isNotBlank(str)) {
            String[] arr = str.split(SP);
            if (null != arr) {
                for (String kv : arr) {
                    if (StringUtils.isNotBlank(kv)) {
                        String[] ar = kv.split(SSP);
                        if (null != ar && ar.length == 2) {
                            String key = decode(ar[0]);
                            String val = decode(ar[1]);
                            if (StringUtils.isNotEmpty(val)) {
                                attrs.put(key, val);
                            }
                        }
                    }
                }
            }
        }
        return attrs;
    }

    private static String encode(String val) {
        return StringUtils.replace(StringUtils.replace(val, SP, R_SP), SSP, R_SSP);
    }

    private static String decode(String val) {
        return StringUtils.replace(StringUtils.replace(val, R_SP, SP), R_SSP, SSP);
    }


    public static void main(String[] args) {
        Map<String,String> attributes = new HashMap<>();
        attributes.put("aa","ffff");
        attributes.put("bb","kkkk");
        attributes.put("cc",  JSON.toJSONString(attributes));

       String str = toString(attributes);

        System.out.print(str);


        attributes = fromString(str);

        System.out.print(attributes.get("aa"));
    }

    private static final int DEFAULT_BUFFER_SIZE = 2048;

    private static final String DEFAULT_ENCODE = "ISO-8859-1";

    private static Map<String,String> attributesEncodeKeyMap;

    private static Map<String,String> attributesEncodeValueMap;

    private static Map<String,String> attributesDecodeKeyMap;

    static{
        attributesEncodeKeyMap = new HashMap<String, String>();
        attributesEncodeValueMap = new HashMap<String, String>();
        attributesDecodeKeyMap = genDecodeKeyMap(attributesEncodeKeyMap);
    }

    private static Map<String, String> genDecodeKeyMap(Map<String, String> attributesEncodeKeyMap) {
        Map<String,String> attributesMap = new HashMap<String, String>();
        Iterator<Map.Entry<String, String>> iterator = attributesMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            attributesMap.put(entry.getValue(), entry.getKey());
        }
        return attributesMap;
    }

    public static String encodeAttributesKey(String attributesString){
        Map<String,String> attributesEncodeMap  = new HashMap<String, String>();
        Map<String,String> attributesMap = fromString(attributesString);
        Iterator<Map.Entry<String, String>> iterator = attributesMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            if(attributesEncodeKeyMap.containsKey(entry.getKey())){
                attributesEncodeMap.put(attributesEncodeKeyMap.get(entry.getKey()), entry.getValue());
            }else{
                attributesEncodeMap.put(entry.getKey(), entry.getValue());
            }
        }

        return toString(attributesEncodeMap);
    }



    public static String decodeAttributesKey(String attributesString){
        Map<String,String> attributesDecodeMap  = new HashMap<String, String>();
        Map<String,String> attributesMap = fromString(attributesString);
        Iterator<Map.Entry<String, String>> iterator = attributesMap.entrySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next().getKey();
            if(attributesDecodeKeyMap.containsKey(key)){
                attributesDecodeMap.put(attributesDecodeKeyMap.get(key), attributesMap.get(key));
            }else{
                attributesDecodeMap.put(key, attributesMap.get(key));
            }
        }

        return toString(attributesDecodeMap);
    }

    public static String zipString(String sourceStr) {
        return zipString(sourceStr, DEFAULT_ENCODE);
    }

    public static String zipString(String sourceStr, String encode) {
        ByteArrayOutputStream bos = null;
        GZIPOutputStream os = null;
        byte[] bs = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new GZIPOutputStream(bos);
            os.write(sourceStr.getBytes("UTF-8"));
            os.close();
            bos.close();
            bs = bos.toByteArray();
            return new String(bs, encode);
        } catch (Exception ex) {
            return sourceStr;
        } finally {
            bs = null;
            bos = null;
            os = null;
        }
    }

    public static String unzipString(String str) {
        return unzipString(str, DEFAULT_ENCODE);
    }

    public static String unzipString(String str, String encode) {
        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = null;
        GZIPInputStream is = null;
        byte[] buf = null;
        try {
            bis = new ByteArrayInputStream(str.getBytes(encode));
            bos = new ByteArrayOutputStream();
            is = new GZIPInputStream(bis);
            buf = new byte[DEFAULT_BUFFER_SIZE];
            int len;
            while ((len = is.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }
            is.close();
            bis.close();
            bos.close();
            return bos.toString("UTF-8");
        } catch (Exception ex) {
            return str;
        } finally {
            bis = null;
            bos = null;
            is = null;
            buf = null;
        }
    }
}
