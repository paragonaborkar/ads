/*******************************************************************************
 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/
package refactor.services;

import java.util.List;
import java.util.Set;

import com.netapp.ads.exception.NetAppAdsException;
import com.netapp.ads.models.Host;


public interface HostService {

	/**
	 * Creates the.
	 *
	 * @param entity
	 *            the entity
	 * @throws ApplicationException
	 *             the application exception
	 */
	void create(Host entity) throws NetAppAdsException;

	/**
	 * Update.
	 *
	 * @param entity
	 *            the entity
	 * @return the host entity
	 * @throws ApplicationException
	 *             the application exception
	 */
	Host update(Host entity) throws NetAppAdsException;

	/**
	 * Delete by id.
	 *
	 * @param entity
	 *            the entity
	 * @throws ApplicationException
	 *             the application exception
	 */
	void deleteById(Host entity) throws NetAppAdsException;

	/**
	 * Gets the by id.
	 *
	 * @param id
	 *            the id
	 * @return the by id
	 * @throws ApplicationException
	 *             the application exception
	 */
	Host getById(int id) throws NetAppAdsException;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 * @throws ApplicationException
	 *             the application exception
	 */
	List<Host> getAll() throws NetAppAdsException;

	/**
	 * Gets the hosts by qtree id.
	 *
	 * @param qtreeId
	 *            the qtree id
	 * @return the hosts by qtree id
	 * @throws ApplicationException
	 *             the application exception
	 */
	List<Host> getHostsByQtreeId(int qtreeId) throws NetAppAdsException;

	/**
	 * Gets the resolver list by qtree id.
	 *
	 * @param qtreeId
	 *            the qtree id
	 * @return the resolver list by qtree id
	 * @throws ApplicationException
	 *             the application exception
	 */
	String getResolverListByQtreeId(int qtreeId) throws NetAppAdsException;

	/**
	 * Take qTree ID as input and returns List of hosts
	 * 
	 * @param qtreeId
	 * @return
	 * @throws ApplicationException
	 */
	String getHostIdListByQtreeId(int qtreeId) throws NetAppAdsException;

	/**
	 * Gets the host name by id.
	 *
	 * @param hostIdList
	 *            the host id list
	 * @return the host name by id
	 * @throws ApplicationException
	 *             the application exception
	 */
	Set<String> getHostNameById(List<Integer> hostIdList) throws NetAppAdsException;

}
