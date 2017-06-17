package aal.blog.service.impl;

import aal.blog.service.PostService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import aal.blog.model.Post;
import aal.blog.repository.PostRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Resource
    private PostRepository postRepository;

    @Override
    @CacheEvict(value = {"post", "posts"}, allEntries = true)
    public Post add(Post post) {
        return postRepository.saveAndFlush(post);
    }

    @Override
    @Cacheable("post")
    public long findLastPostId(long userId) {
        return postRepository.findLastPostId(userId);
    }

    @Override
    @Cacheable("posts")
    public List<Post> findPosts(long userId) {
        return postRepository.findByUser(userId);
    }

    @Override
    @Cacheable("post")
    public Post findPost(long id) {
        return postRepository.findOne(id);
    }

    @Override
    @CacheEvict(value = {"post", "posts"}, allEntries = true)
    public void remove(long id) {
        postRepository.delete(id);
    }
}
