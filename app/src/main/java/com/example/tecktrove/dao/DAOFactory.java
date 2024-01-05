package com.example.tecktrove.dao;

public abstract class DAOFactory {

    private static DAOFactory factory = null;

    /**
     * Returns the factory for producing the DAO objects.
     *
     * @return the factory for producing the DAO objects
     */
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

    /**
     * Returns the object for the interface {@link CustomerDAO}
     *
     * @return  the DAO object
     */
    public abstract CustomerDAO getCustomerDAO();

    /**
     * Returns the object for the interface {@link EmployerDAO}
     *
     * @return  the DAO object
     */
    public abstract EmployerDAO getEmployerDAO();

    /**
     * Returns the object for the interface {@link ComponentDAO}
     *
     * @return  the DAO object
     */
    public abstract ComponentDAO getComponentDAO();

    /**
     * Returns the object for the interface {@link SynthesisDAO}
     *
     * @return  the DAO object
     */
    public abstract SynthesisDAO getSynthesisDAO();

    /**
     * Returns the object for the interface {@link OrderDAO}
     *
     * @return  the DAO object
     */
    public abstract OrderDAO getOrderDAO();

    /**
     * Returns the object for the interface {@link ItemDAO}
     *
     * @return  the DAO object
     */
    public abstract ItemDAO getItemDAO();
}
