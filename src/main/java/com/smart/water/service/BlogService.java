package com.smart.water.service;

import com.smart.water.entity.Blog;

import java.util.List;

public interface BlogService {
    int delete(int id);
    List<Blog> getAllByAuthorAndTime(String author, String time);
}
