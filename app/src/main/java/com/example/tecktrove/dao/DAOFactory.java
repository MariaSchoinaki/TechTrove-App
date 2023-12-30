package com.example.tecktrove.dao;

public abstract class DAOFactory {

    private static DAOFactory factory = null;

    public static DAOFactory getFactory(){
        if (factory == null) {
            String className = null;

            if (System.getProperty("daofactory") != null) {
                className = System.getProperty("daofactory");
            }

            try {
                factory = (DAOFactory) Class.forName(className).newInstance();
            } catch (Exception e) {
                //throw new TecktroveException(e);
            }
        }
        return factory;
    }

    public abstract CustomerDAO getCustomerDAO();

    public abstract EmployerDAO getEmployerDAO();

    public abstract ComponentDAO getComponentDAO();

    public abstract SynthesisDAO getSynthesisDAO();

    public abstract OrderDAO getOrderDAO();

    public abstract ItemDAO getItemDAO();
}
