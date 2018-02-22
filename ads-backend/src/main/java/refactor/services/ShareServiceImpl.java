/*******************************************************************************
 * Copyright (c) 2016, 2017 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/
package refactor.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netapp.ads.exception.NetAppAdsException;
import com.netapp.ads.models.NasVolume;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.models.Share;
import com.netapp.ads.repos.NasVolumeRepository;
import com.netapp.ads.repos.ShareRepository;


@Service
public class ShareServiceImpl implements ShareService {

	private static final Logger logger = LoggerFactory.getLogger(ShareServiceImpl.class);

	@Autowired 
	private ShareRepository dao;

	@Autowired 
	private NasVolumeRepository nasVolumeRepo;


	public ShareServiceImpl() {
		super();
	}

	public void create(Share entity)  throws NetAppAdsException {
		try
		{
			//			dao.create(entity);
			dao.save(entity);
		}catch( Exception e )
		{
			logger.error( e.getMessage(),e );
			throw new NetAppAdsException( e.getMessage() );
		}
	}

	public Share update(Share entity)  throws NetAppAdsException {
		try
		{
			//			return dao.update(entity);
			return dao.save(entity);
		}catch( Exception e )
		{
			logger.error( e.getMessage(),e );
			throw new NetAppAdsException( e.getMessage() );
		}
	}

	public List<Share> getAll()  throws NetAppAdsException 
	{
		try
		{
			//		return dao.getAll();
			return dao.findAll();

		}catch( Exception e )
		{
			logger.error( e.getMessage(),e );
			throw new NetAppAdsException( e.getMessage() );
		}
	}


	public Share getById(int id)  throws NetAppAdsException 
	{
		try
		{
			//			return dao.getById(id);
			return dao.findOne(id);

		}catch( Exception e )
		{
			logger.error( e.getMessage(),e );
			throw new NetAppAdsException( e.getMessage() );
		}
	}


	public void deleteById(Share entity)  throws NetAppAdsException {
		try
		{
			//			dao.deleteById(entity);
			dao.delete(entity);

		}catch( Exception e )
		{
			logger.error( e.getMessage(),e );
			throw new NetAppAdsException( e.getMessage() );
		}
	}

	// FIXME: Global update.... don't pass id, pass something more descriptive, like "shareId", "controllerId", etc.
	// id below is actually volumeID
	// ADS: return type changed from int to Long
	public Long getHostCountByVol(int id)  throws NetAppAdsException 
	{
		try
		{
			// MMS: private static final String GET_BY_VOL = "Select a From ShareEntity a Where a.volumeId=:volId";
			//			return dao.getHostCountByVol(id);

			//			ADS: relation nas_volume --> qtree --> share
			return nasVolumeRepo.countOfSharesForOneVolume(id);


		}catch( Exception e )
		{
			logger.error( e.getMessage(),e );
			throw new NetAppAdsException( e.getMessage() );
		}
	}

	public List<Share> getByVol(int volId) throws NetAppAdsException 
	{
		try
		{
			// MMS: private static final String GET_BY_VOL = "Select a From ShareEntity a Where a.volumeId=:volId";
			//		return dao.getByVol(volId);

			//		ADS: relation nas_volume --> qtree --> share
			// FIXME: is there a more efficient way of getting this data? prehaps using sql in a repo like nasVolumeRepo.getCountofSharesForOneVolume(id);?
			NasVolume nasVolume = nasVolumeRepo.getOne(volId);
			List<Qtree> qtrees = nasVolume.getQtrees();

			List<Share> shareList = new ArrayList<Share>();

			for(Qtree qtree : qtrees) {
				shareList.addAll(qtree.getShares());
			}

			return shareList;

		}catch( Exception e )
		{
			logger.error( e.getMessage(),e );
			throw new NetAppAdsException( e.getMessage() );
		}
	}  	

	public List<String> getNameByVol(int volId) throws NetAppAdsException 
	{
		try
		{
			// MMS: 	private static final String GET_NAME_BY_VOL = "Select DISTINCT a.name From ShareEntity a Where a.volumeId=:volId";
			//        return dao.getNameByVol(volId);

			//		ADS: relation nas_volume --> qtree --> share
			// FIXME: is there a more efficient way of getting this data? prehaps using sql in a repo like nasVolumeRepo.getCountofSharesForOneVolume(id);?
			NasVolume nasVolume = nasVolumeRepo.getOne(volId);
			List<Qtree> qtrees = nasVolume.getQtrees();

			List<String> shareNameList = new ArrayList<String>();

			for(Qtree qtree : qtrees) {
				for(Share share : qtree.getShares())
					shareNameList.add(share.getShareName()); 
			}

			return shareNameList;

		}catch( Exception e )
		{
			logger.error( e.getMessage(),e );
			throw new NetAppAdsException( e.getMessage() );
		}
	}   

}
