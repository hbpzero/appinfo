package com.appinfo.service.imp;

import com.appinfo.dao.DataDictionaryMapper;
import com.appinfo.pojo.DataDictionary;
import com.appinfo.service.DataDictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DataDictionaryServiceImp implements DataDictionaryService {
    @Resource
    DataDictionaryMapper dataDictionaryMapper;
    @Override
    public List<DataDictionary> getFlatform() {
        return dataDictionaryMapper.getFlatform();
    }
}
