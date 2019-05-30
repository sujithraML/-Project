package com.aspire.travelexploration.manager;

import java.util.ArrayList;
import java.util.List;
import com.aspire.travelexploration.daoimpl.TourPackagesDAO;
import com.aspire.travelexploration.entity.TourPackage;
public class TourPackageManager {
	TourPackagesDAO tourPackageDao=new TourPackagesDAO();
	List<Object> tourPackages=new ArrayList<Object>();
	
	public boolean addPackage(TourPackage tourPackage) {
		return tourPackageDao.addDetails(tourPackage);
	}
	public List<Object> selectPackage(TourPackage tourPackage){
		tourPackages=tourPackageDao.selectDetails(tourPackage);
		return tourPackages;
	}
	public List<TourPackage> selectPackagesByPackageType(TourPackage tourPackage){
		return tourPackageDao.selectPackageByPackageType(tourPackage);	
	}
	public List<TourPackage> selectPackagesByPricing(TourPackage tourPackage){
		return tourPackageDao.selectPackageByPricing(tourPackage);
	}
	public List<TourPackage> selectPackagesByCountry(TourPackage tourPackage){
		return tourPackageDao.selectPackageByCountry(tourPackage);
	}
}
