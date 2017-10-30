package com.jdkgroup.atom;

public interface ProgressCallback {
    public void onProgress(long downloaded, long total);
}
