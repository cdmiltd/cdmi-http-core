/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package pw.cdmi.core.http.client;

import java.util.LinkedHashMap;
import java.util.Map;

import pw.cdmi.core.http.Protocol;

/**
 * Client configurations for accessing to target services.
 */
public class ClientConfiguration {
    
    private static final int DEFAULT_MAX_RETRIES = 0;
    
    public static final int DEFAULT_CONNECTION_REQUEST_TIMEOUT = -1;
    public static final int DEFAULT_CONNECTION_TIMEOUT = 50 * 1000;
    public static final int DEFAULT_SOCKET_TIMEOUT = 50 * 1000;
    public static final int DEFAULT_MAX_CONNECTIONS = 1024;
    public static final long DEFAULT_CONNECTION_TTL = -1;
    public static final long DEFAULT_IDLE_CONNECTION_TIME = 60 * 1000;
    public static final int DEFAULT_VALIDATE_AFTER_INACTIVITY = 2 * 1000;
    public static final int DEFAULT_THREAD_POOL_WAIT_TIME = 60 * 1000;
    public static final int DEFAULT_REQUEST_TIMEOUT = 5 * 60 * 1000;
    public static final long DEFAULT_SLOW_REQUESTS_THRESHOLD = 5 * 60 * 1000;

    public static final boolean DEFAULT_USE_REAPER = true;
    
    private int maxErrorRetry = DEFAULT_MAX_RETRIES;
    private int connectionRequestTimeout = DEFAULT_CONNECTION_REQUEST_TIMEOUT;
    private int connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
    private int socketTimeout = DEFAULT_CONNECTION_TIMEOUT;
    private int maxConnections = DEFAULT_MAX_CONNECTIONS;
    private long connectionTTL = DEFAULT_CONNECTION_TTL;
    private boolean useReaper = DEFAULT_USE_REAPER;
    private long idleConnectionTime = DEFAULT_IDLE_CONNECTION_TIME;

    private Protocol protocol = Protocol.HTTP;
    
    private String proxyHost = null;
    private int proxyPort = -1;
    private String proxyUsername = null;
    private String proxyPassword = null;
    private String proxyDomain = null;
    private String proxyWorkstation = null;

    private boolean supportCname = true;
    
    private boolean sldEnabled = false;
    
    private int requestTimeout = DEFAULT_REQUEST_TIMEOUT;
    private boolean requestTimeoutEnabled = false;
    private long slowRequestsThreshold = DEFAULT_SLOW_REQUESTS_THRESHOLD;
    
    private Map<String, String> defaultHeaders = new LinkedHashMap<String, String>();

    private boolean crcCheckEnabled = true;

    /**
     * ????????????????????????????????????
     * @return ??????????????????????????????
     */
    public String getProxyHost() {
        return proxyHost;
    }

    /**
     * ????????????????????????????????????
     * @param proxyHost
     *          ??????????????????????????????
     */
    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    /**
     * ??????????????????????????????
     * @return ????????????????????????
     */
    public int getProxyPort() {
        return proxyPort;
    }

    /**
     * ??????????????????????????????
     * @param proxyPort ????????????????????????
     * @throws ClientException
     */
    public void setProxyPort(int proxyPort) throws ClientException {
        if (proxyPort <= 0) {
            throw new ClientException("ParameterIsInvalid", null);
        }
        this.proxyPort = proxyPort;
    }

    /**
     * ??????????????????????????????????????????
     * @return ????????????
     */
    public String getProxyUsername() {
        return proxyUsername;
    }

    /**
     * ??????????????????????????????????????????
     * @param proxyUsername
     *          ????????????
     */
    public void setProxyUsername(String proxyUsername) {
        this.proxyUsername = proxyUsername;
    }

    /**
     * ???????????????????????????????????????
     * @return ?????????
     */
    public String getProxyPassword() {
        return proxyPassword;
    }

    /**
     * ???????????????????????????????????????
     * @param proxyPassword
     *          ?????????
     */
    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    /**
     * ????????????NTLM???????????????????????????Windows?????????????????????
     * @return ?????????
     */
    public String getProxyDomain() {
        return proxyDomain;
    }

    /**
     * ????????????NTLM???????????????????????????Windows?????????????????????
     * @param proxyDomain
     *          ?????????
     */
    public void setProxyDomain(String proxyDomain) {
        this.proxyDomain = proxyDomain;
    }

    /**
     * ??????NTLM??????????????????Windows??????????????????
     * @return NTLM??????????????????Windows??????????????????
     */
    public String getProxyWorkstation() {
        return proxyWorkstation;
    }

    /**
     * ??????NTLM??????????????????Windows??????????????????
     * ????????????????????????????????????NTLM?????????????????????????????????
     * @param proxyWorkstation
     *          NTLM??????????????????Windows??????????????????
     */
    public void setProxyWorkstation(String proxyWorkstation) {
        this.proxyWorkstation = proxyWorkstation;
    }

    /**
     * ???????????????????????????HTTP????????????
     * @return ??????HTTP????????????
     */
    public int getMaxConnections() {
        return maxConnections;
    }

    /**
     * ???????????????????????????HTTP????????????
     * @param maxConnections
     *          ??????HTTP????????????
     */
    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    /**
     * ??????????????????????????????????????????????????????????????????????????????
     * 0?????????????????????????????????????????????
     * @return ????????????????????????????????????????????????????????????????????????
     */
    public int getSocketTimeout() {
        return socketTimeout;
    }

    /**
     * ??????????????????????????????????????????????????????????????????????????????
     * 0?????????????????????????????????????????????
     * @param socketTimeout
     *          ????????????????????????????????????????????????????????????????????????
     */
    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    /**
     * ?????????????????????????????????????????????????????????
     * @return ???????????????????????????????????????????????????
     */
    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    /**
     * ?????????????????????????????????????????????????????????
     * @param connectionTimeout
     *          ???????????????????????????????????????????????????
     */
    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }
    
    /**
     * ????????????????????????????????????????????????????????????????????????
     * 0???????????????????????????????????????????????????-1???
     * @return ?????????????????????????????????????????????
     */
    public int getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    /**
     * ????????????????????????????????????????????????????????????????????????
     * @param connectionRequestTimeout
     *          ???????????????????????????????????????????????????
     */
    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    /**
     * ??????????????????????????????????????????????????????????????????????????????????????????3???
     * @return ??????????????????????????????????????????????????????
     */
    public int getMaxErrorRetry() {
        return maxErrorRetry;
    }

    /**
     * ??????????????????????????????????????????????????????????????????????????????????????????3???
     * @param maxErrorRetry
     *          ??????????????????????????????????????????????????????
     */
    public void setMaxErrorRetry(int maxErrorRetry) {
        this.maxErrorRetry = maxErrorRetry;
    }
    
    /**
     * ???????????????????????????????????????
     * @return ?????????????????????
     */
    public long getConnectionTTL() {
        return connectionTTL;
    }

    /**
     * ???????????????????????????????????????
     * @param connectionTTL ??????????????????????????????????????????
     */
    public void setConnectionTTL(long connectionTTL) {
        this.connectionTTL = connectionTTL;
    }

    /**
     * ??????????????????{@link IdleConnectionReaper}?????????????????????
     */
    public boolean isUseReaper() {
        return useReaper;
    }

    /**
     * ??????????????????{@link IdleConnectionReaper}?????????????????????
     */
    public void setUseReaper(boolean useReaper) {
        this.useReaper = useReaper;
    }
    
    /**
     * ????????????????????????????????????
     * @return ??????????????????????????????
     */
    public long getIdleConnectionTime() {
        return idleConnectionTime;
    }

    /**
     * ????????????????????????????????????????????????????????????????????????????????????60??????
     */
    public void setIdleConnectionTime(long idleConnectionTime) {
        this.idleConnectionTime = idleConnectionTime;
    }

    /**
     * ????????????OSS?????????????????????HTTP/HTTPS?????? 
     */
    public Protocol getProtocol() {
        return protocol;
    }

    /**
     * ????????????OSS?????????????????????HTTP/HTTPS??????
     */
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    

    /**
     * ??????????????????Cname??????Endpoint???????????????????????????
     * @return ???????????????True???????????????False
     */
    public boolean isSupportCname() {
        return supportCname;
    }

    /**
     * ??????????????????Cname??????Endpoint???
     * 
     * <p>????????????True??????????????????Cname?????????????????????????????????????????????Cname???
     *     ?????????????????????????????????????????????????????????False???????????????Cname???????????????
     * ????????????????????????????????????</p>
     * 
     * @param supportCname ????????????Cname??????Endpoint???
     */
    public ClientConfiguration setSupportCname(boolean supportCname) {
        this.supportCname = supportCname;
        return this;
    }

    /**
     * ?????????????????????????????????Second Level Domain???????????????????????????????????????
     * @return ??????????????????True???????????????False
     */
    public boolean isSLDEnabled() {
        return sldEnabled;
    }

    /**
     * ?????????????????????????????????Second Level Domain?????????????????????
     * @param enabled ????????????????????????????????????
     */
    public ClientConfiguration setSLDEnabled(boolean enabled) {
        this.sldEnabled = enabled;
        return this;
    }
    
    /**
     * ????????????????????????????????????????????????????????????????????????2?????????????????????
     * @return ??????????????????
     */
    public int getValidateAfterInactivity() {
        return DEFAULT_VALIDATE_AFTER_INACTIVITY;
    }

    /**
     * ???????????????????????????????????????????????????
     * @return true ????????? false ??????
     */
    public boolean isRequestTimeoutEnabled() {
        return requestTimeoutEnabled;
    }

    /**
     * ?????????????????????????????????
     * @param requestTimeoutEnabled
     */
    public void setRequestTimeoutEnabled(boolean requestTimeoutEnabled) {
        this.requestTimeoutEnabled = requestTimeoutEnabled;
    }
    
    /**
     * ????????????????????????????????????????????????5?????????
     */
    public void setRequestTimeout(int requestTimeout) {
        this.requestTimeout = requestTimeout;
    }
    
    /**
     * ??????????????????????????????????????????
     */
    public int getRequestTimeout() {
        return requestTimeout;
    }
    
    /**
     * ???????????????????????????????????????????????????????????????????????????????????????????????????5?????????
     */
    public long getSlowRequestsThreshold() {
        return slowRequestsThreshold;
    }

    /**
     * ?????????????????????????????????????????????????????????????????????????????????????????????
     */
    public void setSlowRequestsThreshold(long slowRequestsThreshold) {
        this.slowRequestsThreshold = slowRequestsThreshold;
    }
    
    /**
     * ???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
     */
    public Map<String, String> getDefaultHeaders() {
        return defaultHeaders;
    }

    /**
     * ???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
     * @param defaultHeaders ???????????????
     */
    public void setDefaultHeaders(Map<String, String> defaultHeaders) {
        this.defaultHeaders = defaultHeaders;
    }

    /**
     * ???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
     * @param key ???????????????
     * @param value ?????????????????????
     */
    public void addDefaultHeader(String key, String value) {
        this.defaultHeaders.put(key, value);
    }
    
    /**
     * ??????????????????CRC???????????????????????????????????????????????????CRC????????????????????????
     * @return true ????????? false ??????
     */
    public boolean isCrcCheckEnabled() {
        return crcCheckEnabled;
    }

    /**
     * ??????????????????CRC???????????????????????????????????????????????????CRC????????????????????????
     * @param crcCheckEnabled
     */
    public void setCrcCheckEnabled(boolean crcCheckEnabled) {
        this.crcCheckEnabled = crcCheckEnabled;
    }
    
}
