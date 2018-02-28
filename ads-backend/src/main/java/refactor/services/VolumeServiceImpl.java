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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netapp.ads.exception.NetAppAdsException;
import com.netapp.ads.models.Controller;
import com.netapp.ads.models.NasVolume;
import com.netapp.ads.repos.ControllerRepository;
import com.netapp.ads.repos.NasVolumeRepository;


@Service
public class VolumeServiceImpl implements VolumeService	{
	
	private static final Logger logger = LoggerFactory.getLogger(VolumeServiceImpl.class);
	@Autowired 
	private NasVolumeRepository dao;
	
	@Autowired 
	private ControllerRepository controllerRepo;

    public VolumeServiceImpl() {
        super();
    }

	public void create(NasVolume entity)  throws NetAppAdsException {
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

	public NasVolume update(NasVolume entity)  throws NetAppAdsException {
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

	public List<NasVolume> getAll()  throws NetAppAdsException 
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

	 
	public NasVolume getById(int id)  throws NetAppAdsException 
	{
		try
		{
//			return dao.getById(id);
			return dao.getOne(id);
			
		}catch( Exception e )
		{
			logger.error( e.getMessage(),e );
			throw new NetAppAdsException( e.getMessage() );
		}
	}
	 

	public void deleteById(NasVolume entity)  throws NetAppAdsException {
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

	public List<NasVolume> getByCtrlId(int ctrlId)  throws NetAppAdsException 
	{
		try
		{
			// MMS: private static final String GET_BY_CONTROLLER = "Select a From VolumeEntity a where a.contId=:ctrlId";
//		return dao.getByCtrlId(ctrlId);
		
		//		ADS: relation nas_volume --> controller, n:1
		// Is there a more efficient way?
		Controller controller = controllerRepo.getOne(ctrlId);
		return controller.getNasVolumes();
		
		
		}catch( Exception e )
		{
			logger.error( e.getMessage(),e );
			throw new NetAppAdsException( e.getMessage() );
		}
	}
	
	public int updateDispositionById(int id, String disp, String note)  throws NetAppAdsException {
		try
		{
			// MMS: private static final String UPDATE_DISPOSITION_BY_ID = "Update VolumeEntity a Set a.disposition=:disp, a.justification=:justification where a.intVolId=:intVolId";
//			return dao.updateDispositionById(id,disp,note);
			
			NasVolume nasVolume = dao.getOne(id);
			nasVolume.setDisposition(disp);
			nasVolume.setJustification(note);
			dao.save(nasVolume);
			
			//FIXME: return boolean if ok, or the updated NasVolume if we need it.
			return 1;
			
		}catch( Exception e )
		{
			logger.error( e.getMessage(),e );
			throw new NetAppAdsException( e.getMessage() );
		}
	}

	
	// ADS: return type changed from int to Long
	@Override
	public Long getCountByCtrlId(int contrlId) throws NetAppAdsException {
		try
		{
			// private static final String GET_COUNT_BY_CONT_ID = "Select count(e.intVolId) From VolumeEntity e where e.contId=:ctrlId";
//			return dao.getCountByCtrlId(contrlId);
			
			return dao.countByControllerId(contrlId);
			
		}catch( Exception e )
		{
			logger.error( e.getMessage(),e );
			throw new NetAppAdsException( e.getMessage() );
		}
	}
	
}
