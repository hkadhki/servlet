package ru.netology.repository;

import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;

import java.util.*;

// Stub
public class PostRepository {


  private List<Post> list = new ArrayList<>();
  public List<Post> all() {
    return list;
  }

  public Optional<Post> getById(long id) {
    try {
        return Optional.of(list.get((int) id));
    }catch (IndexOutOfBoundsException e){
      return Optional.empty();
    }
  }

  public Post save(Post post) {
    int id = (int)post.getId();
    if (id == 0){
      list.add(post);
    }else {
      if (list.size() - 1 > id){
        list.set(id,post);
      }else{
        throw new NotFoundException();
      }
    }
    return post;
  }

  public void removeById(long id) {
    list.remove((int)id);
  }
}
