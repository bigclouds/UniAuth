package com.dianrong.common.uniauth.cas.registry;

import java.util.Set;
import org.jasig.cas.monitor.TicketRegistryState;
import org.jasig.cas.ticket.registry.TicketRegistry;

/**
 * 扩展功能, 可以根据用户身份信息获取tgtId,删除Tgt.
 */
public interface TgtIdentityTicketRegistry extends TicketRegistry, TicketRegistryState {
  /**
   * 删除UserId关联的Tgt.
   */
  void removeTgtByUserId(Long userId);

  /**
   * 根据UserId获取关联的Tgt.
   * 有可能同一个账号在多个地方登录.
   */
  Set<String> queryTgtByUserId(Long userId);
}
