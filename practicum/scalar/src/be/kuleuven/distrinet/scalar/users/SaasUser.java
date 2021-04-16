package be.kuleuven.distrinet.scalar.users;

import be.kuleuven.distrinet.scalar.core.User;
import be.kuleuven.distrinet.scalar.core.UserPool;
import be.kuleuven.distrinet.scalar.exceptions.DataException;
import be.kuleuven.distrinet.scalar.exceptions.InternalException;
import be.kuleuven.distrinet.scalar.exceptions.RequestException;
import be.kuleuven.distrinet.scalar.requests.SaasRequest;

public class SaasUser extends User {
	
    SaasUser(UserPool pool) {
        super(pool);
        super.targetUrl();
    }

    @Override
    public void mainLoop() throws DataException {
        SaasRequest request = new SaasRequest(this);
        try {
            request.doRequest();
        } catch (RequestException e) {
            throw new InternalException(e);
        }
    }
}
