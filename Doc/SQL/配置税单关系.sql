--税种
select * from TRET09_TAXTYPE;
--税单
select * from TRET11_RETURN_TYPE;
--税单和税单页面的对应关系 cret10_rf_name+.jsp
select * from TRET10_RETURN_FORM where cret10_rf_uid in (28
,29);
--税种和税单的关系
select * from TRET12_TAXTYPE_RETURNTYPE where cret10_tr_uid in (28,29);
--税单规则和税单页面的对应关系
--规则 := cret18_rule_name+ReturnFormDefinition
select * from TRET18_RETURN_FORM_RULE where CRET18_RFR_UID = 18;

--计算规则表
select * from RU_RULEDEFINE where sys_guid = 42;



select max(cret11_returntype_code) from TRET11_RETURN_TYPE;


