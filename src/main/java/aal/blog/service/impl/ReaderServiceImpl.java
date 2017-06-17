package aal.blog.service.impl;

import aal.blog.model.Reader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import aal.blog.repository.ReaderRepository;
import aal.blog.service.ReaderService;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class ReaderServiceImpl implements ReaderService {
    @Resource
    private ReaderRepository readerRepository;

    @Override
    public Reader add(Reader reader) {
        return readerRepository.saveAndFlush(reader);
    }

    @Override
    public Reader findOne(long userIdMain, long userIdFollower) {
        if (readerRepository.findOne(userIdMain, userIdFollower) == null) {
            return null;
        } else {
            long id = Long.parseLong(String.valueOf(readerRepository.findOne(userIdMain, userIdFollower)));

            return new Reader(id, userIdMain, userIdFollower);
        }
    }

    @Override
    public List<Reader> findAllMain(long userIdMain) {
        return readerRepository.findAllMain(userIdMain);
    }

    @Override
    public List<Reader> findAllFollower(long userIdFollower) {
        return readerRepository.findAllFollower(userIdFollower);
    }

    @Override
    public void remove(long id) {
        readerRepository.delete(id);
    }
}
