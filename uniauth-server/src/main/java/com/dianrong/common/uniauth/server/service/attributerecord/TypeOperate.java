package com.dianrong.common.uniauth.server.service.attributerecord;

import com.dianrong.common.uniauth.server.service.attributerecord.ExtendAttributeRecord.RecordOperate;
import com.dianrong.common.uniauth.server.service.attributerecord.ExtendAttributeRecord.RecordType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *用于唯一的标识某一种日志记录的场景. 
 */
@Getter
@Setter
@ToString
public class TypeOperate {
  /**
   * 操作的属性类型:用户或组.
   */
  RecordType type ;
  
  /**
   * 操作:新增，修改，删除等.
   */
  RecordOperate operate;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((operate == null) ? 0 : operate.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TypeOperate other = (TypeOperate) obj;
    if (operate != other.operate)
      return false;
    if (type != other.type)
      return false;
    return true;
  }
}
