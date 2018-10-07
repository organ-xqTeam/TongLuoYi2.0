package com.tly.service;

import java.util.List;
import java.util.Map;

import com.tly.model.Commissionreward;
import com.tly.model.Partner;

/**
 * 合伙人
 * @ClassName IPartnerService
 * @Author yangweihang
 * @Date 2018年8月26日 下午5:18:14
 */
public interface IPartnerService {
	
	/**
	 * 查询合伙人详情
	 * yangweihang
	 * @Date 2018年8月26日 下午5:08:35
	 * @return
	 */
	public List<Map<String,Object>> selectByPartner();
	
	/**
	 * 查询一级上线 
	 * yangweihang
	 * @Date 2018年8月26日 下午3:05:06
	 * @param wxid
	 * @return
	 */
	Partner selectonone(String wxid);
	
	/**
	 * 查询二级上线
	 * yangweihang
	 * @Date 2018年8月26日 下午3:06:48
	 * @param wxid
	 * @return
	 */
	Partner selectontwo(String wxid);
	
	/**
	 * 查询一级下线
	 * yangweihang
	 * @Date 2018年8月26日 下午3:07:52
	 * @param wxid
	 * @return
	 */
	List<Partner> selectupone(String wxid);
	
	/**
	 * 查询二级 下线
	 * yangweihang
	 * @Date 2018年8月26日 下午3:08:57
	 * @param wxid
	 * @return
	 */
	List<Partner> selectuptwo(String wxid);


    /**
     * 判断该设备是租用的还是购买的  如果是购买的扫码不需要支付
     * @param equipmentnumber 设备编号
     * @return 设备是租用的还是购买的  租用：1 购买：2
     */
    Integer selectEquipmentForm(String equipmentnumber);

    /**
     * 根据他是第几级上线和他的mid查询他应该提多少钱
     * @param i 是第几级上线
     * @param id 他的id
     * @return 应该得到的钱数
     */
    Commissionreward selectMoneyByRank(Integer id);

    /**
     * 查询租用该设备的会员微信id
     * @param equipmentnumber
     * @return 该设备租用者wxid
     */
    String selectPeoByEquipmentnumber(String equipmentnumber);
	
    /**
     * 按微信id查询
     * yangweihang
     * @Date 2018年8月28日 下午3:00:51
     * @param wxid
     * @return
     */
    Partner selectByWxid(String wxid);
    
    /**
     * 按管理员微信id查询合伙人id
     * yangweihang
     * @Date 2018年8月31日 上午11:59:13
     * @param wxid
     * @return
     */
    Integer selectawxidbypid(String wxid);
    
    /**
	* 查询
	* yangweihang
	* @date: 2018年9月1日 上午12:27:30
	* @return List<Map<String,Object>>
	*/
	List<Map<String,Object>> selectbytx();
	
	/**
	 * 新增合伙人
	 * yangweihang
	 * @Date 2018年9月1日 下午6:04:56
	 * @param p
	 * @return
	 */
	int insertbyp(Partner p);
	
	/**
	 * 查询全部合伙人
	 * yangweihang
	 * @Date 2018年9月1日 下午6:10:14
	 * @return
	 */
	List<Partner> selectall();
}
