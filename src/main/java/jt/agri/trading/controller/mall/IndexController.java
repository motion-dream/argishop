
package jt.agri.trading.controller.mall;

import jt.agri.trading.common.IndexConfigTypeEnum;
import jt.agri.trading.controller.vo.NewBeeMallIndexConfigGoodsVO;
import jt.agri.trading.service.NewBeeMallCarouselService;
import jt.agri.trading.service.NewBeeMallIndexConfigService;
import jt.agri.trading.common.Constants;
import jt.agri.trading.controller.vo.NewBeeMallIndexCarouselVO;
import jt.agri.trading.controller.vo.NewBeeMallIndexCategoryVO;
import jt.agri.trading.service.NewBeeMallCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private NewBeeMallCarouselService newBeeMallCarouselService;

    @Resource
    private NewBeeMallIndexConfigService newBeeMallIndexConfigService;

    @Resource
    private NewBeeMallCategoryService newBeeMallCategoryService;

    @GetMapping({"/index", "/", "/index.html"})
    public String indexPage(HttpServletRequest request) {
        List<NewBeeMallIndexCategoryVO> categories = newBeeMallCategoryService.getCategoriesForIndex();
        if (CollectionUtils.isEmpty(categories)) {
            return "error/error_5xx";
        }
        List<NewBeeMallIndexCarouselVO> carousels = newBeeMallCarouselService.getCarouselsForIndex(Constants.INDEX_CAROUSEL_NUMBER);
        List<NewBeeMallIndexConfigGoodsVO> hotGoodses = newBeeMallIndexConfigService.getConfigGoodsesForIndex(IndexConfigTypeEnum.INDEX_GOODS_HOT.getType(), Constants.INDEX_GOODS_HOT_NUMBER);
        List<NewBeeMallIndexConfigGoodsVO> newGoodses = newBeeMallIndexConfigService.getConfigGoodsesForIndex(IndexConfigTypeEnum.INDEX_GOODS_NEW.getType(), Constants.INDEX_GOODS_NEW_NUMBER);
        List<NewBeeMallIndexConfigGoodsVO> recommendGoodses = newBeeMallIndexConfigService.getConfigGoodsesForIndex(IndexConfigTypeEnum.INDEX_GOODS_RECOMMOND.getType(), Constants.INDEX_GOODS_RECOMMOND_NUMBER);
        request.setAttribute("categories", categories);//????????????
        for(NewBeeMallIndexCategoryVO categoryVO:categories){
            System.out.println(categoryVO.toString());
        }

        request.setAttribute("carousels", carousels);//?????????
        request.setAttribute("hotGoodses", hotGoodses);//????????????
        request.setAttribute("newGoodses", newGoodses);//??????
        request.setAttribute("recommendGoodses", recommendGoodses);//????????????
        return "mall/index";
    }
}
