package io.github.dousxcoder.dcredis.adapter;

import io.github.dousxcoder.dcredis.factory.DcredisProxyFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Adapter
 */
public class DcredisProxyFactoryAdapter implements FactoryBean<Object> {

    private final Class<?> interfaceType;

    @Autowired
    private DcredisProxyFactory dcredisProxyFactory;

    /**
     * 构造适配器
     *
     * @param interfaceType type
     */
    public DcredisProxyFactoryAdapter(Class<?> interfaceType) {
        this.interfaceType = interfaceType;
    }

    @Override
    public Object getObject() {
        return dcredisProxyFactory.createProxy(interfaceType);
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceType;
    }

}