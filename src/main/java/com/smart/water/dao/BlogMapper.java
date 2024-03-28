package com.smart.water.dao;

import com.smart.water.entity.Blog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

@Mapper  //让容器加载到这个bean
public interface BlogMapper {
    // 查询所有博文
    List<Blog> getAll();

    /**
     * 根据作者和发布时间检索博文
     * @param author 作者
     * @param time 发布时间
     * @return
     */
    List<Blog> getAllByAuthorAndTime(
            @Param("author") String author
            ,@Param("time") String time);

    /**
     * 插入博文
     * @return
     * @param blog
     */
    int insert(Blog blog);
    /**
     * 按id删除博文
     * @param id
     * @return
     */
    @Delete("delete from blog where id = #{id}")
    int delete(@Param("id") Integer id);

    /**
     * 更新博文信息
     * @param blog
     * @return
     */
    int update(Blog blog);

    /**
     * 按id获取博文
     * @param id
     * @return
     */
    Blog get(@Param("id") Integer id);

    /**
     * 保存博文信息，通过Map参数，以下是单个参数，但是参数的类型不是简单类型，是Map集合
     * @param map
     * @return
     */
    int insertBlogByMap(Map<String,Object> map);

    /**
     * 根据id获取博文信息，将博文信息放到Map集合中
     * @param id
     * @return
     */
    Map<String,Object> selectByIdRetMap(@Param("id") Integer id);

    /**
     * 查询所有的博文信息返回一个放Map集合的List集合
     * @return
     */
    List<Map<String,Object>> selectAllRetListMap();


    /**
     * 查询所有的博文返回一个大Map结合
     * Map集合的key是每条记录的主键值
     * Map集合的value的每条记录
     * @return
     */
    @MapKey("id")
    Map<Integer,Map<String,Object>> selectAllRetMap();

}
