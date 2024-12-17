package com.sirafonso.e_library_users.core.ports.out.http;

import com.sirafonso.e_library_users.core.domain.dtos.response.ResponseBody;

public interface HttpRequestOutputPort {
    String sendGetRequest(String url);
    ResponseBody sendPostRequest(String url, Object payload) throws Exception;
}
