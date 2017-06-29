package ru.esbt.adres.repository;

import java.sql.Types;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import ru.esbt.adres.entity.Data;

/**
 *
 * @author Y.Pashnina
 */
@org.springframework.stereotype.Repository("dataRespitory")
public class DataRepositoryImpl implements DataRepository<Data> {

    @Autowired
    protected JdbcOperations jdbcOperations;

    @Override
    public void persist(Data object) {

        Object[] params = new Object[] { object.getCmOkato(), object.getCmCtext(), object.getCmSocr() };
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };

        jdbcOperations.update("INSERT INTO cm_naspunkt(\n" +
                "            cm_okato, cm_ctext, cm_socr)\n" +
                "    VALUES (cast(? as UUID), ?);", params, types);
    }

    @Override
    public void delete(Data object) {
        jdbcOperations.update("DELETE FROM cm_naspunkt\n" +
                " WHERE cm_okato = '" + object.getCmOkato().toString() + "';");
    }

    @Override
    public Set<String> getRandomData() {
        Set<String> result = new HashSet<>();
        SqlRowSet rowSet = jdbcOperations.queryForRowSet("SELECT cm_socr||' '||cm_ctext data_description FROM cm_naspunkt p LIMIT 50;");
        while (rowSet.next()) {
            result.add(rowSet.getString("data_description"));
        }
        return result;
    }


}