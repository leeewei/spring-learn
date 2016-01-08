/*@(#)HibTransactional.java   2016-1-4 
 * Copy Right 2016 Bank of Communications Co.Ltd.
 * All Copyright Reserved
 */

package com.bankcomm.beijing.hr.annotation.hibernate;

import org.springframework.transaction.annotation.Transactional;

/**
 * 支持Hibnate的事务管理器
 * <p>
 * @version 1.0.0,2016-1-4
 * @author lw
 * @since 1.0.0
 */
@Transactional("hrreTransactionManager")
public @interface HrreTx{
}
