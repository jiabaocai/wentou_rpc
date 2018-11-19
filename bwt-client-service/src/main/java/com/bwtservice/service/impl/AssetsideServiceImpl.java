package com.bwtservice.service.impl;

import com.bwtservice.entity.AssetsidePropertyWithBLOBs;
import com.bwtservice.entity.AssetsideWithBLOBs;
import com.bwtservice.mapper.AssetsideMapper;
import com.bwtservice.mapper.AssetsidePropertyMapper;
import com.bwtservice.service.AssetsideService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AssetsideServiceImpl implements AssetsideService {

    @Resource
    AssetsideMapper assetsideMapper;
    @Resource
    AssetsidePropertyMapper assetsidePropertyMapper;

    @Override
    public int addAssetside(AssetsideWithBLOBs assetsideWithBLOBs) {
        return assetsideMapper.insertSelective(assetsideWithBLOBs);
    }

    @Override
    public int addAssetsideProperty(AssetsidePropertyWithBLOBs assetsidePropertyWithBLOBs) {
        return assetsidePropertyMapper.insertSelective(assetsidePropertyWithBLOBs);
    }

    @Override
    public PageInfo<AssetsideWithBLOBs> getAssetsideByPage(AssetsideWithBLOBs assetsideWithBLOBs,int pageNum,int pageSize) {
        //引入PageHelper插件
        //在使用pageHelper插件在查询之前只需调用，startPage，传入页码pn，设置数据显示多少
        PageHelper.startPage(pageNum, pageSize);
        List<AssetsideWithBLOBs> list = assetsideMapper.selectByExample(assetsideWithBLOBs);
        PageInfo<AssetsideWithBLOBs> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public AssetsidePropertyWithBLOBs getAssProByAssId(int assetsideId) {
        return assetsidePropertyMapper.selectByPrimaryAssId(assetsideId);
    }

    @Override
    public int editAssetside(AssetsideWithBLOBs assetsideWithBLOBs) {
        return assetsideMapper.updateByPrimaryKeySelective(assetsideWithBLOBs);
    }

    @Override
    public int editAssetsidePropety(AssetsidePropertyWithBLOBs assetsidePropertyWithBLOBs) {
        return assetsidePropertyMapper.updateByPrimaryKeySelective(assetsidePropertyWithBLOBs);
    }
}
