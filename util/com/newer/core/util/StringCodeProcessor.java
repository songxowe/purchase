package com.newer.core.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * Json 状态码转换
 * 
 * 
 */
public class StringCodeProcessor implements JsonValueProcessor {

	public StringCodeProcessor() {

	}

	public Object processArrayValue(Object value, JsonConfig config) {
		return process(value);
	}

	public Object processObjectValue(String key, Object value, JsonConfig config) {
		return process(value);
	}

	private Object process(Object value) {
		if (value instanceof String) {
			String s=value.toString();
			if("C000-1".equals(s)){
				s="公开求购";
			}else if("C000-2".equals(s)){
				s="定向询价";
			}else if("S002-0".equals(s)){
				s="不同意";
			}else if("S002-1".equals(s)){
				s="同意";
			}else if("Z000-1".equals(s)){
				s="军标";
			}else if("Z000-2".equals(s)){
				s="国际标";
			}else if("Z000-3".equals(s)){
				s="铁标";
			}else if("Z000-4".equals(s)){
				s="国标";
			}else if("Z000-5".equals(s)){
				s="需方提供的技术文件标准";
			}else if("Z000-7".equals(s)){
				s="其他";
			}else if("S003-1".equals(s)){
				s="一年";
			}else if("S003-2".equals(s)){
				s="两年";
			}else if("S003-3".equals(s)){
				s="三年";
			}else if("B001-1".equals(s)){
				s="结果未发";
			}else if("B001-2".equals(s)){
				s="中标";
			}else if("B001-3".equals(s)){
				s="未中";
			}else if("S000-1".equals(s)){
				s="0%";
			}else if("S000-2".equals(s)){
				s="4%";
			}else if("S000-3".equals(s)){
				s="6%";
			}else if("S000-4".equals(s)){
				s="17%";
			}else if("B000-0".equals(s)){
				s="包装物不回收";
			}else if("B000-1".equals(s)){
				s="包装物回收";
			}else if("Y000-1".equals(s)){
				s="国际（国家）标准";
			}else if("Y000-2".equals(s)){
				s="行业标准";
			}else if("Y000-3".equals(s)){
				s="企业标准";
			}else if("Y001-1".equals(s)){
				s="铁快";
			}else if("Y001-2".equals(s)){
				s="EMS航空";
			}else if("Y001-3".equals(s)){
				s="中铁快运";
			}else if("Y001-4".equals(s)){
				s="普邮";
			}else if("Y001-5".equals(s)){
				s="送货";
			}else if("Y001-6".equals(s)){
				s="提货";
			}else if("Y001-7".equals(s)){
				s="汽运";
			}else if("F000-1".equals(s)){
				s="货到验收合格、自收到有效发票后90天付款";
			}else if("F000-2".equals(s)){
				s="货到验收合格、自收到有效发票后付款";
			}else if("F000-3".equals(s)){
				s="现场考核后付款";
			}else if("F000-4".equals(s)){
				s="货到验收合格、自收到有效发票后30天付款";
			}else if("F000-5".equals(s)){
				s="款到发货";
			}else if("F000-6".equals(s)){
				s="其它约定";
			}else if("J000-1".equals(s)){
				s="供方所在地";
			}else if("J000-2".equals(s)){
				s="需方工厂";
			}else if("Y002-1".equals(s)){
				s="供方";
			}else if("Y002-2".equals(s)){
				s="需方";
			}else if("F001-1".equals(s)){
				s="汇兑（电汇、信汇）";
			}else if("F001-2".equals(s)){
				s="托收承付";
			}else if("F001-3".equals(s)){
				s="银行支票";
			}else if("F001-4".equals(s)){
				s="银行本票";
			}else if("F001-5".equals(s)){
				s="银行汇票";
			}else if("F001-6".equals(s)){
				s="委托收款";
			}else if("F001-7".equals(s)){
				s="商业票据";
			}else if("B001-1".equals(s)){
				s="散装";
			}else if("B001-2".equals(s)){
				s="托盘";
			}else if("B001-3".equals(s)){
				s="卷带";
			}else if("B001-4".equals(s)){
				s="管装";
			}else if("B001-5".equals(s)){
				s="防静电";
			}else if("B001-6".equals(s)){
				s="防震,防潮,防挤压";
			}else if("B001-7".equals(s)){
				s="防摩擦";
			}else if("B001-8".equals(s)){
				s="整箱";
			}else if("B001-9".equals(s)){
				s="整卷";
			}else if("C001-10".equals(s)){
				s="需求计划未确认";
			}else if("C001-20".equals(s)){
				s="未编采购计划";
			}else if("C001-30".equals(s)){
				s="采购计划未报批";
			}else if("C001-40".equals(s)){
				s="采购计划未审批";
			}else if("C001-50".equals(s)){
				s="采购计划未下达";
			}else if("C001-51".equals(s)){
				s="采购计划审批不通过";
			}else if("C001-60".equals(s)){
				s="未编询价书";
			}else if("C001-70".equals(s)){
				s="询价书未发出";
			}else if("C001-80".equals(s)){
				s="询价书已发出";
			}else if("C001-90".equals(s)){
				s="询价已截止";
			}else if("C001-100".equals(s)){
				s="已揭示报价";
			}else if("C001-110".equals(s)){
				s="合同申请未报批";
			}else if("C001-120".equals(s)){
				s="合同申请未审核";
			}else if("C001-130".equals(s)){
				s="合同申请部长审批已审批";
			}else if("C001-131".equals(s)){
				s="合同申请部长审批不通过";
			}else if("C001-140".equals(s)){
				s="合同申请厂长审批已审批";
			}else if("C001-141".equals(s)){
				s="合同申请厂长审批不通过";
			}else if("C001-150".equals(s)){
				s="合同已签订";
			}else if("C001-160".equals(s)){
				s="合同已归档";
			}else if("G000-1".equals(s)){
				s="国有企业";
			}else if("G000-2".equals(s)){
				s="集体企业";
			}else if("G000-3".equals(s)){
				s="股份合作企业";
			}else if("G000-4".equals(s)){
				s="有限责任公司";
			}else if("G000-5".equals(s)){
				s="股份有限公司";
			}else if("G000-6".equals(s)){
				s="私营独资企业";
			}else if("G000-7".equals(s)){
				s="中外合资经营企业";
			}else if("S004-0".equals(s)){
				s="不可用";
			}else if("S004-1".equals(s)){
				s="可用";
			}else if("W000-W40".equals(s)){
				s="金属模电阻";
			}else if("W000-W41".equals(s)){
				s="线绕电阻";
			}else if("W000-W60".equals(s)){
				s="二级管";
			}else if("W000-W61".equals(s)){
				s="发光器件";
			}else if("W000-W62".equals(s)){
				s="三级管";
			}else if("W000-W64".equals(s)){
				s="晶振";
			}
			return s;
		}
		return value;
	}

}
