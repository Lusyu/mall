package com.macro.mall.controller;



import com.macro.mall.common.CommonResult;
import com.macro.mall.model.PmsSkuStock;
import com.macro.mall.service.PmsSkuStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "pmsSukStockController",description = "商品SKU管理")
@RestController
@RequestMapping("/sku")
public class PmsSukStockController {

    @Autowired
    private PmsSkuStockService pmsSkuStockService;


    @ApiOperation("根据商品的id 和 sku编码模糊查询出对应sku")
    @GetMapping("/{pid}")
    public CommonResult<List<PmsSkuStock>> getList(@PathVariable("pid") Long id,
                                                   @RequestParam(value = "keyword",required = false) String keyword){
        List<PmsSkuStock> pmsSkuStorckAll = pmsSkuStockService.getPmsSkuStorckAll(id, keyword);
        return CommonResult.success(pmsSkuStorckAll);
    }

    @ApiOperation("根据商品的id 和 sku编码模糊查询出对应sku")
    @PostMapping("/update/{pid}")
    public CommonResult update(@PathVariable Long pid,@RequestBody List<PmsSkuStock> skuStockList){
        Integer count = pmsSkuStockService.update(pid, skuStockList);
        return count>0?CommonResult.success(count):CommonResult.failed();
    }
}
