package com.xy.transformplugin;


import com.android.build.api.transform.Context;
import com.android.build.api.transform.QualifiedContent;
import com.android.build.api.transform.Transform;
import com.android.build.api.transform.TransformException;
import com.android.build.api.transform.TransformInvocation;
import com.android.build.gradle.external.cmake.server.Project;
import com.android.build.gradle.internal.pipeline.TransformManager;

import java.io.IOException;
import java.util.Set;

//https://blog.csdn.net/tscyds/article/details/78082861
public class CustomTransform extends Transform {

    Project project;

    public CustomTransform(Project project) {
        this.project = project;
    }

    @Override
    public void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        super.transform(transformInvocation);
        System.out.println("==================" +
                "=====================doPathTransform{ context=${context}, " +
                "inputs=${inputs}, referencedInputs=${referencedInputs}," +
                " outputProvider=${outputProvider}, isIncremental=${isIncremental}");

    }

    @Override
    public String getName() {
        return CustomTransform.class.getSimpleName();
    }

    @Override
    public Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS;
    }

    @Override
    public Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT;
    }

    @Override
    public boolean isIncremental() {
        return false;
    }
}
