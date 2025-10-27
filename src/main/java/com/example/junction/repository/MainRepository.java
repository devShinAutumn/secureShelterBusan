package com.example.junction.repository;


import com.example.junction.dto.MainDto;
import com.example.junction.entity.*;
import com.example.junction.dto.CollectorDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class MainRepository {

    private SqlSession sqlSession;

    private String namespace = "mapper.mainMapper";

    public MainRepository(SqlSession sqlSession) { this.sqlSession = sqlSession; }


    public SsbExpect getSsbExpect(HashMap<String, Object> map) throws Exception {
        return sqlSession.selectOne(namespace + ".getSsbExpect", map);
    }
    public List<SsbShelter> getSsbShelter(HashMap<String, Object> map) throws Exception {
        return sqlSession.selectList(namespace + ".getSsbShelter", map);
    }
    public List<LivingPopulation> getLivingPopulation(HashMap<String, Object> map) throws Exception {
        return sqlSession.selectList(namespace + ".getLivingPopulation", map);
    }
    public List<RipCrnt> getRipCrnt(HashMap<String, Object> map) throws Exception {
        return sqlSession.selectList(namespace + ".getRipCrnt", map);
    }
    public List<TidalObserv> getTidalObserv(HashMap<String, Object> map) throws Exception {
        return sqlSession.selectList(namespace + ".getTidalObserv", map);
    }
    public List<ObsAsosTim> getObsAsosTim(HashMap<String, Object> map) throws Exception {
        return sqlSession.selectList(namespace + ".getObsAsosTim", map);
    }
    public int insertBusanRainfalldepthInfo(CollectorDto mm) {
        return sqlSession.insert(namespace + ".insertBusanRainfalldepthInfo", mm);

    }
    public List<RhymeRhymeans> getRhymeRhymeans(HashMap<String, Object> map) throws Exception {
        return sqlSession.selectList(namespace + ".getRhymeRhymeans", map);
    }
}
