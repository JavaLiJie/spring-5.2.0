package com.common;

import com.bean.UserImportBean;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//通过import注册到容器
		return new String[]{UserImportBean.class.getName()};
	}
}
