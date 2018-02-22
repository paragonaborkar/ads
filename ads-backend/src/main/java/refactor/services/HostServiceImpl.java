/*******************************************************************************
 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/
package refactor.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netapp.ads.exception.NetAppAdsException;
import com.netapp.ads.models.Host;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.models.Share;
import com.netapp.ads.repos.HostRepository;
import com.netapp.ads.repos.QtreeRepository;
import com.netapp.ads.repos.ShareRepository;


// REFACTOR COMMENT *********************************************************************
// THE MAJORITY OF THE BELOW IS PROVIDED OUT OF THE BOX BY SPRING DATA
// MAKING THIS "WORK" FOR NOW, BUT SHOULD BE REPLACED SINCE THESE MEHTHODS ARE REDUNDENT


@Service
public class HostServiceImpl implements HostService {

	private static final Logger logger = LoggerFactory.getLogger(HostServiceImpl.class);

	private static final String DELIMITER = ",";

	@Autowired
	private HostRepository dao;
	//private HostDao dao;

	@Autowired
	private ShareRepository shareDao;
	//private ShareDao shareDao;

	@Autowired
	private QtreeRepository qtreeRepo;

	public HostServiceImpl() {
		super();
	}

	public void create(Host entity) throws NetAppAdsException {
		try {
			//			dao.create(entity);
			dao.save(entity);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new NetAppAdsException(e.getMessage());
		}
	}

	public Host update(Host entity) throws NetAppAdsException {
		try {
			// return dao.update(entity);
			return dao.save(entity);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new NetAppAdsException(e.getMessage());
		}
	}

	public List<Host> getAll() throws NetAppAdsException {
		try {
			// return dao.getAll();
			return dao.findAll();

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new NetAppAdsException(e.getMessage());
		}
	}

	public Host getById(int id) throws NetAppAdsException {
		try {
			//			return dao.getById(id);
			return dao.getOne(id);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new NetAppAdsException(e.getMessage());
		}
	}

	public void deleteById(Host entity) throws NetAppAdsException {
		try {
			//			dao.deleteById(entity);
			dao.delete(entity);

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new NetAppAdsException(e.getMessage());
		}
	}

	public List<Host> getHostsByQtreeId(int qtreeId) throws NetAppAdsException {

		try {

			//			List<Integer> hostIdList = shareDao.getHostIdByQtreeId(qtreeId);
			List<Host> hostEntities = new ArrayList<Host>();
			//			for (Integer hostId : hostIdList) {

			//				Host entity = dao.getById(hostId);
			//				hostEntities.add(entity);
			//			}
			//			return hostEntities;

			//			In ADS: Host --> Share --> QTree
			// Get the QTree by ID
			Qtree qtree = qtreeRepo.getOne(qtreeId);
			// Get the Shares
			List<Share> shares = qtree.getShares();
			// Get the Hosts
			for (Share s : shares) {
				hostEntities.add(s.getHost());
			}
			return hostEntities;

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new NetAppAdsException(e.getMessage());
		}

	}

	public String getResolverListByQtreeId(int qtreeId) throws NetAppAdsException {

		//In MMS, the resolver columns was added: DIS-429 add resolver column to host table
		List<Host> hostEntities = getHostsByQtreeId(qtreeId);
		StringBuffer result = new StringBuffer();
		for (Host entity : hostEntities) {
			result.append(entity.getResolver());
			result.append(DELIMITER);
		}
		result.setLength(Math.max(result.length() - 1, 0));
		return result.toString();
	}

	public String getHostIdListByQtreeId(int qtreeId) throws NetAppAdsException {

		List<Host> hostEntities = getHostsByQtreeId(qtreeId);
		StringBuffer hostId = new StringBuffer();
		for (Host hostEntity : hostEntities) {
			hostId.append(hostEntity.getId());
			hostId.append(DELIMITER);
		}
		hostId.setLength(Math.max(hostId.length() - 1, 0));
		return hostId.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netapp.vitae.service.HostService#getHostNameById(java.util.List)
	 */
	@Override
	public Set<String> getHostNameById(List<Integer> hostIdSet) throws NetAppAdsException {
		try {

			// return dao.getHostNameById(hostIdSet);
			// Inlining the function from MMS: getHostNameById():
			List<String> hostNameList = new ArrayList<String>();

			Set<String> hostNameSet = new HashSet<String>();		

			for (Integer hostId : hostIdSet) {
				if (null != hostId) {
					//						hostNameList.add((String) manager.createQuery(GET_HOST_NAME_OR_IPADDRESS + hostId).getSingleResult());
					hostNameList.add(dao.getOne(hostId).getHostName());
				}
			}
			hostNameSet.addAll(hostNameList);
			return hostNameSet;


		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new NetAppAdsException(e.getMessage());
		}

	}

}
