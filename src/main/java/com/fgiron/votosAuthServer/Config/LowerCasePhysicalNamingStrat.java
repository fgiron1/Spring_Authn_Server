package com.fgiron.votosAuthServer.Config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import static org.springframework.util.StringUtils.capitalize;

public class LowerCasePhysicalNamingStrat extends PhysicalNamingStrategyStandardImpl{

    private static final long serialVersionUID = 1L;
    public static final LowerCasePhysicalNamingStrat INSTANCE = new LowerCasePhysicalNamingStrat();

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return super.toPhysicalTableName((new Identifier(
                capitalize(
                    name.getText().toLowerCase()), name.isQuoted())), context);
    }

    //@Override
    /*public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment context) {
        return super.toPhysicalTableName((new Identifier(
                capitalize(
                    name.getText().toLowerCase()), name.isQuoted())), context);
    }*/

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        boolean esHaVotado = name.getText().contains("votado");
        
        return super.toPhysicalColumnName((new Identifier(
                    name.getText().toLowerCase(), name.isQuoted())), context);
         /*else {
            return super.toPhysicalColumnName((new Identifier(
                    camelCase(name.getText()), name.isQuoted())), context);
        }*/
        
    }
    
    private static String camelCase(String s){
        String[] parts = s.split("_");
        String camelCaseResult = "";
        
        for(String part : parts){
            camelCaseResult += capitalize(part);
        }

        return camelCaseResult;

    }


}