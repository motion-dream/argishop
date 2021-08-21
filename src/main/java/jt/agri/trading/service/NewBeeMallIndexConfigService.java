
package jt.agri.trading.service;

import jt.agri.trading.controller.vo.NewBeeMallIndexConfigGoodsVO;
import jt.agri.trading.entity.IndexConfig;
import jt.agri.trading.util.PageQueryUtil;
import jt.agri.trading.util.PageResult;

import java.util.List;

public interface NewBeeMallIndexConfigService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getConfigsPage(PageQueryUtil pageUtil);

    String saveIndexConfig(IndexConfig indexConfig);

    String updateIndexConfig(IndexConfig indexConfig);

    IndexConfig getIndexConfigById(Long id);

    /**
     * 返回固定数量的首页配置商品对象(首页调用)
     *
     * @param number
     * @return
     */
    List<NewBeeMallIndexConfigGoodsVO> getConfigGoodsesForIndex(int configType, int number);

    Boolean deleteBatch(Long[] ids);
}
