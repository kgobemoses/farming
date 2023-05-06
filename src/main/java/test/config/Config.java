package test.config;

import java.io.Serializable;

import javax.enterprise.inject.Produces;

import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;

public class Config implements Serializable {
	private static final long serialVersionUID = 7895803787851376319L;

	@Produces
	public RepresentationFactory obtainRepresentationFactory(){
		return new StandardRepresentationFactory()
		//				.withFlag(RepresentationFactory.SINGLE_ELEM_ARRAYS)
		.withFlag(RepresentationFactory.PRETTY_PRINT)
		.withFlag(RepresentationFactory.STRIP_NULLS);
	}
}
