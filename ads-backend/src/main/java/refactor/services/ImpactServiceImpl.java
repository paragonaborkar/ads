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
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netapp.ads.exception.NetAppAdsException;
import com.netapp.ads.models.Controller;
import com.netapp.ads.models.Export;
import com.netapp.ads.models.ExportsHostXRef;
import com.netapp.ads.models.Host;
import com.netapp.ads.models.NasVolume;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.models.Share;
import com.netapp.ads.repos.ExportRepository;


//ADS: impact(s) is renamed to exports


@Service
public class ImpactServiceImpl implements ImpactService	{

	private static final Logger logger = LoggerFactory.getLogger(ImpactServiceImpl.class);
	@Autowired 
	private ExportRepository dao;


	public ImpactServiceImpl() {
		super();
	}

	public void create(Export entity)  throws NetAppAdsException {
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

	public Export update(Export entity)  throws NetAppAdsException {
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

	public List<Export> getAll()  throws NetAppAdsException 
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


	public Export getById(int id)  throws NetAppAdsException 
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


	public void deleteById(Export entity)  throws NetAppAdsException {
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

	public List<Export> getByVolume(NasVolume entity)  throws NetAppAdsException 
	{
		try
		{
			//			From MMS: This f(x) does this: private static final String SELECT_BY_VOLUME = "Select a From ImpactEntity a where a.vFiler=:vFiler";
			//		return dao.getByVolume(entity);

			// ADS does not have vfiler or vserver on export, so let's get by relation
			// ADS relation is: volume --> controller --> exports
			Controller controller = entity.getController();

			// FIXME: There can be multiple exports for 1 controller.
			Export oneExportShouldReturnMultipleButDoesnt = controller.getExport();

			List<Export> exports = new ArrayList<Export>();
			exports.add(oneExportShouldReturnMultipleButDoesnt);

			return exports;

		}catch( Exception e )
		{
			logger.error( e.getMessage(),e );
			throw new NetAppAdsException( e.getMessage() );
		}
	}

	public List<Export> getByShare(String name)  throws NetAppAdsException 
	{
		try
		{
			//			From MMS: This f(x) does this: private static final String SELECT_BY_SHARE = "Select a From ImpactEntity a where a.path=:path";
			//		return dao.getByShare(name);

			// ADS relation is:  export --> controller --> nas_volume --> qtree --> share
			// We may not need to get the list of exports using relations
			return dao.findByVolumePath(name);
		}
		catch( Exception e ) {
			logger.error( e.getMessage(),e );
			throw new NetAppAdsException( e.getMessage() );
		}
	}


	//FIXME: This function returns a  list of strings. Could rename function to make more sense.
	public List<String> getHostsByShare(String name)  throws NetAppAdsException 
	{
		try
		{
			//			From MMS: This f(x) does this: private static final String SELECT_HOSTS_BY_SHARE = "Select DISTINCT a.hostName From ImpactEntity a where a.path=:path";
//			return dao.getHostsByShare(name);

			// ADS: host name is no longer in export table. Get using relation.
			// ADS relation is: exports --> exports_host_x_ref --> host
			List<String> hostNames = new ArrayList<String>();

			List<Export> exportList = dao.findByVolumePath(name);
			for(Export export : exportList) {
				List<ExportsHostXRef> xrefs = export.getExportsHostXRefs();
				for(ExportsHostXRef xref : xrefs) {
					Host host = xref.getHost();
					hostNames.add(host.getHostName());
				}
			}

			return hostNames;


		} catch( Exception e )
		{
			logger.error( e.getMessage(),e );
			throw new NetAppAdsException( e.getMessage() );
		}

	}
}
