/*
 * MIT License
 *
 * Copyright (c) 2021 yedf
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dtmcli;

import cn.hutool.http.HttpResponse;
import common.IdGenerator;
import common.TransType;

public class TransBase {
    private String gid;
    private TransType transType;
    private IdGenerator idGenerator;
    private String dtm;
    private boolean waitResult;

    public TransBase(TransType transType, String dtm, boolean waitResult) throws Exception {
        this.gid = IdGenerator.genGid(dtm);
        this.transType = transType;
        this.dtm = dtm;
        this.waitResult = waitResult;
        this.idGenerator = new IdGenerator("");
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public TransType getTransType() {
        return transType;
    }

    public void setTransType(TransType transType) {
        this.transType = transType;
    }

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public String getDtm() {
        return dtm;
    }

    public void setDtm(String dtm) {
        this.dtm = dtm;
    }

    public boolean isWaitResult() {
        return waitResult;
    }

    public void setWaitResult(boolean waitResult) {
        this.waitResult = waitResult;
    }

    public static boolean checkResult(HttpResponse response) {
        if (!response.isOk()) {
            return false;
        }
        if (response.body().contains("FAILURE")) {
            return false;
        }
        return true;
    }
}