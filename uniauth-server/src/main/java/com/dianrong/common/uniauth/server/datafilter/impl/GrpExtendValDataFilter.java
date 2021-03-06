package com.dianrong.common.uniauth.server.datafilter.impl;

import com.dianrong.common.uniauth.common.util.ObjectUtil;
import com.dianrong.common.uniauth.server.data.entity.GrpExtendVal;
import com.dianrong.common.uniauth.server.data.entity.GrpExtendValExample;
import com.dianrong.common.uniauth.server.data.mapper.GrpExtendValMapper;
import com.dianrong.common.uniauth.server.datafilter.FilterData;
import com.dianrong.common.uniauth.server.util.CheckEmpty;
import com.dianrong.common.uniauth.server.util.TypeParseUtil;
import com.dianrong.common.uniauth.server.util.UniBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 组扩展值数据过滤.
 *
 * @author wanglin
 */
@Service("grpExtendValDataFilter")
public class GrpExtendValDataFilter extends CurrentAbstractDataFilter<GrpExtendVal> {

  @Autowired
  private GrpExtendValMapper grpExtendValMapper;

  @Override
  protected String getProcessTableName() {
    return UniBundle.getMsg("data.filter.table.name.grpextendval");
  }

  @Override
  protected boolean multiFieldsDuplicateCheck(FilterData... equalsField) {
    GrpExtendValExample condition = new GrpExtendValExample();
    GrpExtendValExample.Criteria criteria = condition.createCriteria();
    criteria.andTenancyIdEqualTo(getTenancyId());
    // 构造查询条件
    for (FilterData fd : equalsField) {
      switch (fd.getType()) {
        case FIELD_TYPE_GRP_ID:
          criteria.andGrpIdEqualTo(TypeParseUtil.parseToIntegerFromObject(fd.getValue()));
          break;
        case FIELD_TYPE_EXTEND_ID:
          criteria.andExtendIdEqualTo(TypeParseUtil.parseToLongFromObject(fd.getValue()));
          break;
        default:
          break;
      }
    }
    int count = grpExtendValMapper.countByExample(condition);
    if (count > 0) {
      return true;
    }
    return false;
  }

  @Override
  protected GrpExtendVal getEnableRecordByPrimaryKey(Integer id) {
    CheckEmpty.checkEmpty(id, "GrpExtendValId");
    GrpExtendValExample condition = new GrpExtendValExample();
    condition.createCriteria().andIdEqualTo(TypeParseUtil.parseToLongFromObject(id));
    List<GrpExtendVal> grpExtendValList = grpExtendValMapper.selectByExample(condition);
    if (ObjectUtil.IsNotEmptyOrNull(grpExtendValList)) {
      return grpExtendValList.get(0);
    }
    return null;
  }
}
