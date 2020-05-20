package com.yitihua3.exam.config;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Service("ehCacheObserver")
public class EhCacheObserver {
    private static Logger log= LoggerFactory.getLogger(EhCacheObserver.class);

    @Autowired
    private EhCacheManager shiroCacheManager;

    @Autowired
    private EhCacheCacheManager springCacheManager;

    private CacheManager cacheManager;

    /**
     * SPRING:是表明对springboot的缓存，SHIRO是表明对SHIRO的缓存
     */
    public enum CacheManagerType{
        SPRING,SHIRO
    }

    public void setCacheManagerType(CacheManagerType type){
        if (type== CacheManagerType.SPRING) {
            cacheManager=springCacheManager.getCacheManager();
        } else {
            cacheManager=shiroCacheManager.getCacheManager();
        }
    }

    /**
     * 获取所有缓存的名称
     * @return
     */
    public String[] getCacheNames(){
        return cacheManager.getCacheNames();
    }

    /**
     * 根据名称获取缓存对象
     * @param name
     * @return
     */
    public Ehcache getEhcache(String name){
        return cacheManager.getEhcache(name);
    }

    /**
     * 获取缓存名中所有的key
     * @param name
     * @return
     */
    public List getEhcacheKeys(String name){
        return getEhcache(name).getKeys();
    }

    /**
     * 根据缓存名和key获取Element对象
     * @param name
     * @param key
     * @return
     */
    public Element getElements(String name,String key){
        Ehcache cache = getEhcache(name);
        if(cache == null){
            return null;
        }

        return cache.getQuiet(key);
    }


    public List<Ehcache> getEhCaches(){
        String[] cacheNames = getCacheNames();
        List<Ehcache> list = new ArrayList<Ehcache>();
        for(String cacheName:cacheNames){
            list.add(cacheManager.getEhcache(cacheName));
        }
        return list;
    }

    public static String pareTime(long millis) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(millis);

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            return formatter.format(calendar.getTime());
        } catch (Exception e) {
            log.error("", e);
        }
        return null;
    }

    public void printCache(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
//        CacheManagerService cacheManager = this;
        String[] cacheNames = this.getCacheNames();
        for (String cacheName:cacheNames){
            List list = this.getEhcacheKeys(cacheName);
            response.getWriter().println("缓存名：<p style='color:red'>"+cacheName+"</p>");
            response.getWriter().print("<p style='white-space:pre'>"+ StringUtils.rightPad("Key", 70));
            response.getWriter().print(" | ");
            response.getWriter().print(StringUtils.rightPad("HintCount", 10));
            response.getWriter().print(" | ");
            response.getWriter().print(StringUtils.rightPad("CreationTime", 50));
            response.getWriter().print(" | ");
            response.getWriter().print(StringUtils.rightPad("LastAccessTime", 50));
            response.getWriter().print(" | ");
            response.getWriter().print(StringUtils.rightPad("TimeToLive(ms)", 15));
            response.getWriter().print(" | ");
            response.getWriter().print(StringUtils.rightPad("TimeToIdle(ms)", 15));
            response.getWriter().print(" | ");
            response.getWriter().print(StringUtils.rightPad("ObjectValue", 200));
            response.getWriter().print(" | "+"</p>");
            response.getWriter().print("<br/>");
            for (Object cache : list) {
                Element element = this.getElements(cacheName, cache.toString());
                response.getWriter().print("<p style='white-space:pre'>"+StringUtils.rightPad(cache.toString(), 70));//key name
                response.getWriter().print(" | ");
                response.getWriter().print(StringUtils.rightPad("" + element.getHitCount(), 10));//命中次数
                response.getWriter().print(" | ");
                response.getWriter().print(StringUtils.rightPad(EhCacheObserver.pareTime(element.getCreationTime()), 50));//创建时间
                response.getWriter().print(" | ");
                response.getWriter().print(StringUtils.rightPad(EhCacheObserver.pareTime(element.getLastAccessTime()), 25));//最后访问时间
                response.getWriter().print(" | ");
                response.getWriter().print(StringUtils.rightPad("" + element.getTimeToLive(), 15));   //存活时间
                response.getWriter().print(" | ");
                response.getWriter().print(StringUtils.rightPad("" + element.getTimeToIdle(), 15));   //空闲时间
                response.getWriter().print(" | ");
                response.getWriter().print(StringUtils.rightPad("" + element.getObjectValue().toString(), 200));
                response.getWriter().print(" | "+"</p>");
                response.getWriter().print("<br/>");
            }
        }

    }
}