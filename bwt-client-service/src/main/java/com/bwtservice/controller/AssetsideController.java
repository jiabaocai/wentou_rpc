package com.bwtservice.controller;


import com.bwtservice.entity.AssetsidePropertyWithBLOBs;
import com.bwtservice.entity.AssetsideWithBLOBs;
import com.bwtservice.service.AssetsideService;
import com.bwtservice.util.BaseResult;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 资产端接口
 */

@Api(value="资产端controller",description="资产端接口",tags={"资产端接口"})
@RestController()
@RequestMapping("/v1/assetside/")
public class AssetsideController {
    private static final Logger logger = LoggerFactory.getLogger(AssetsideController.class);
    @Resource
    private AssetsideService assetsideService;


    @ApiOperation(value = "新增资产端信息接口")
    @PostMapping("/addAssetside")
    public BaseResult addAssetside(@RequestBody AssetsideWithBLOBs assetsideWithBLOBs) {
        try {
            assetsideService.addAssetside(assetsideWithBLOBs);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(assetsideWithBLOBs.getAssetside_id());
    }


    @ApiOperation(value = "新增资产信息表")
    @PostMapping("/addAssetsideProperty")
    public BaseResult<? extends Object> addAssetsideProperty(@RequestBody AssetsidePropertyWithBLOBs assetsidePropertyWithBLOBs) {
        try {
            if(assetsidePropertyWithBLOBs.getAssetside_id()!=null){
                AssetsidePropertyWithBLOBs a= assetsideService.getAssProByAssId(assetsidePropertyWithBLOBs.getAssetside_id());
                if(a!=null){
                    BaseResult.error("信息已存在");
                }
            }
            assetsideService.addAssetsideProperty(assetsidePropertyWithBLOBs);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.successNull();
    }


    @ApiOperation(value = "资产端查询接口")
    @GetMapping("/getAssetside")
    public BaseResult list(String name, Integer status, int pageNum, int pageSize) {
        PageInfo<AssetsideWithBLOBs> result;
        try {
            AssetsideWithBLOBs withBLOBs = new AssetsideWithBLOBs();
            withBLOBs.setStatus(status);
            withBLOBs.setName(name);
            result = assetsideService.getAssetsideByPage(withBLOBs, pageNum, pageSize);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(result);
    }

    @ApiOperation(value = "修改资产端信息接口")
    @PostMapping("/editAssetside")
    public BaseResult editAssetside(@RequestBody AssetsideWithBLOBs assetsideWithBLOBs) {
        try {
            assetsideService.editAssetside(assetsideWithBLOBs);
        } catch (Exception e) {
            logger.error(e.getMessage());
            BaseResult.error(e.getMessage());
        }
        return BaseResult.successNull();
    }

    @ApiOperation(value = "修改资产信息接口")
    @PostMapping("/editAssetsidePropety")
    public BaseResult<Object> editAssetsideProprty(@RequestBody AssetsidePropertyWithBLOBs assetsidePropertyWithBLOBs) {
        try {
            AssetsidePropertyWithBLOBs a=assetsideService.getAssProByAssId(assetsidePropertyWithBLOBs.getAssetside_id());
            if(a!=null){
                assetsideService.editAssetsidePropety(assetsidePropertyWithBLOBs);
            }else {
                assetsideService.addAssetsideProperty(assetsidePropertyWithBLOBs);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            BaseResult.error(e.getMessage());
        }
        return BaseResult.successNull();
    }


    @ApiOperation(value = "根据资产端id查询资产信息")
    @GetMapping("/getAssProByAssId")
    public BaseResult getAssetsidePropertyById(int assetsideId) {
        AssetsidePropertyWithBLOBs result;
        try {
            result = assetsideService.getAssProByAssId(assetsideId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(result);
    }

    @ApiOperation(value = "根据id查询资产端信息")
    @GetMapping("/getAssByAssId")
    public BaseResult getAssByAssId(int assetsideId) {
        AssetsideWithBLOBs result;
        try {
            result = assetsideService.getAssByassId(assetsideId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(result);
    }


}
