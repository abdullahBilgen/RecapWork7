package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.BrandService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.BrandDao;
import com.example.reCapProject.entities.concretes.Brand;
import com.example.reCapProject.entities.request.create.CreateBrandRequest;
import com.example.reCapProject.entities.request.delete.DeleteBrandRequest;
import com.example.reCapProject.entities.request.update.UpdateBrandRequest;

@Service
public class BrandManager implements BrandService{
	
	private BrandDao brandDao;
	
	@Autowired
	public BrandManager(BrandDao brandDao) {
		super();
		this.brandDao = brandDao;
	}

	@Override
	public DataResult<List<Brand>> getAll() {
		
		return new SuccessDataResult<List<Brand>>
		(this.brandDao.findAll(),Messages.GETALL);
	}

	@Override
	public DataResult<Brand> getById(int brandId) {
		
		return new SuccessDataResult<Brand>
		(this.brandDao.getById(brandId),Messages.GETID);
	}

	@Override
	public Result add(CreateBrandRequest createBrandRequest) {
		
		Brand brand=new Brand();
		brand.setBrandName(createBrandRequest.getBrandName());
		
		this.brandDao.save(brand);
		return new SuccessResult(Messages.BRANDADD);
	}

	@Override
    public Result update(UpdateBrandRequest updateBrandRequest) {

        Brand brand = new Brand();
        brand.setBrandId(updateBrandRequest.getBrandId());
        brand.setBrandName(updateBrandRequest.getBrandName());

        this.brandDao.save(brand);
        return new SuccessResult(Messages.BRANDUPDATE);
    }

	@Override
    public Result delete(DeleteBrandRequest deleteBrandRequest) {
		
        Brand brand= new Brand();
        brand.setBrandId(this.brandDao.getByBrandName(deleteBrandRequest.getBrandName()).getBrandId());

        this.brandDao .delete(brand);
        return new SuccessResult(Messages.BRANDDELETE);
    }

	@Override
	public DataResult<List<Brand>> getByCarId(int carId) {
		
		return new SuccessDataResult<List<Brand>>
		(this.brandDao.findAll(),Messages.BRANDLIST);
	}
}
