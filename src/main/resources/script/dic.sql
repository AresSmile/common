-- 会计接口版本
delete from `param_data_dictionary` where parent_dic_code ='accountant_interface_version' or dic_code ='accountant_interface_version';
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('accountant_interface_version', '会计接口版本', '0', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('0', 'V1.2', 'accountant_interface_version', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('1', 'V1.3', 'accountant_interface_version', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('2', 'V1.4', 'accountant_interface_version', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('3', 'V2.3', 'accountant_interface_version', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('4', 'V2.4', 'accountant_interface_version', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('5', 'V2.5', 'accountant_interface_version', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('6', 'V2.6', 'accountant_interface_version', -6, 'chy', now(), 'chy', now());

-- 养老金账户标识
delete from `param_data_dictionary` where parent_dic_code ='pension_acc_flag' or dic_code ='pension_acc_flag';
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('pension_acc_flag', '养老金账户标识', '0', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('0', '否', 'pension_acc_flag', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('1', '是', 'pension_acc_flag', -6, 'chy', now(), 'chy', now());

-- 冻结原因字典增加 5-内部员工自动冻结解冻
delete from param_data_dictionary where parent_dic_code = 'account_trade_frozen_causes' and dic_code = '5';
INSERT INTO `base_biz`.`param_data_dictionary`( `dic_code`, `dic_explain`, `parent_dic_code`, `dic_sort`, `param1`, `param2`, `param3`, `param_explain`, `delete_flag`, `create_user_id`, `create_time`, `update_user_id`, `update_time`) VALUES ( '5', '内部员工自动冻结解冻', 'account_trade_frozen_causes', -6, '', NULL, NULL, NULL, 0, 'zeze', '2020-03-06 05:33:02', 'zeze', '2020-03-06 05:33:02');

-- 基金拆分方案---拆分方式
delete from `param_data_dictionary` where parent_dic_code ='split_type' or dic_code ='split_type';
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('split_type', '拆分方式', '0', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('0', '每单位拆分份额', 'split_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('1', '分配总基金资产', 'split_type', -6, 'chy', now(), 'chy', now());

-- 基金拆分方案--赎回折算方式
delete from `param_data_dictionary` where parent_dic_code ='redeem_convert_type' or dic_code ='redeem_convert_type';
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('redeem_convert_type', '赎回折算方式', '0', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('0', '不折算', 'redeem_convert_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('1', '全部按比例确认', 'redeem_convert_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('2', '全额赎回时拆分后份额全部赎回', 'redeem_convert_type', -6, 'chy', now(), 'chy', now());

-- 处理标志--分红处理方案增加 2-处理中状态
delete from `param_data_dictionary` where parent_dic_code ='dividend_deal_flag' or dic_code ='dividend_deal_flag';
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('dividend_deal_flag', '分红处理标志', '0', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('0', '未处理', 'dividend_deal_flag', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('1', '已处理', 'dividend_deal_flag', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('2', '处理中', 'dividend_deal_flag', -6, 'chy', now(), 'chy', now());


-- 基金拆分方案--拆分份额方式
delete from `param_data_dictionary` where parent_dic_code ='split_share_type' or dic_code ='split_share_type';
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('split_share_type', '拆分份额方式', '0', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('0', '按照明细拆分到原份额明细', 'split_share_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('1', '按照明细生成拆分份额', 'split_share_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('2', '按照汇总生成拆分份额', 'split_share_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('3', '按照汇总拆分到原份额明细', 'split_share_type', -6, 'chy', now(), 'chy', now());


-- 强制赎回类型
delete from `param_data_dictionary` where parent_dic_code ='force_red_type' or dic_code ='force_red_type';
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('force_red_type', '拆分份额方式', '0', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('1', '小份额强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('2', '管理人主动强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('3', 'T+0垫资账户强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('4', 'T+0剩余收益强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('5', '短期理财违约赎回额度控制强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('6', '拆分强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('7', 'HiFas自营账户强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('8', '份额配比强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('9', '未付收益强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('a', '短期理财违约强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('b', '预期收益率产品强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('c', '周期理财产品强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('d', '存款类产品强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('e', '拆分份额强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('g', '升降级新级别强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('h', '短期理财到期小份额强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('k', '定期发起小份额强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('p', '违约赎回强赎', 'force_red_type', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('x', '保证金解约赎回', 'force_red_type', -6, 'chy', now(), 'chy', now());


INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('2', '处理中', 'dividend_deal_flag', -6, 'chy', now(), 'chy', now());


-- 产品验资成立--产品验资成立状态
delete from `param_data_dictionary` where parent_dic_code ='prd_set_up_status' or dic_code ='prd_set_up_status';
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('prd_set_up_status', '产品验资成立状态', '0', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('0', '待验资', 'prd_set_up_status', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('1', '验资中', 'prd_set_up_status', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('2', '验资成功', 'prd_set_up_status', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('3', '验资失败', 'prd_set_up_status', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('4', '产品成立中', 'prd_set_up_status', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('5', '产品成立', 'prd_set_up_status', -6, 'chy', now(), 'chy', now());
INSERT INTO `param_data_dictionary` (dic_code,dic_explain,parent_dic_code,dic_sort,create_user_id,create_time,update_user_id,update_time) VALUES ('6', '产品成立失败', 'prd_set_up_status', -6, 'chy', now(), 'chy', now());



