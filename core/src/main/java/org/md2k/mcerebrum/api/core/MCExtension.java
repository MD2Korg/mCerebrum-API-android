/*
 * Copyright (c) 2018, The University of Memphis, MD2K Center of Excellence
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.md2k.mcerebrum.api.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import org.md2k.mcerebrum.api.core.extensionapi.Action;
import org.md2k.mcerebrum.api.core.extensionapi.IBackgroundProcess;
import org.md2k.mcerebrum.api.core.extensionapi.IConfigure;
import org.md2k.mcerebrum.api.core.extensionapi.IPermission;
import org.md2k.mcerebrum.api.core.extensionapi.MCAction;
import org.md2k.mcerebrum.api.core.extensionapi.MCUserInterface;
import org.md2k.mcerebrum.api.core.extensionapi.Param;
import org.md2k.mcerebrum.api.core.extensionapi.UserInterface;

import java.util.ArrayList;

public class MCExtension implements Parcelable {
    private String title;
    private String summary;
    private String description;
    private String version;
    private String packageName;
    private Bitmap icon;
    private IConfigure iConfigure;
    private IBackgroundProcess iBackgroundProcess;
    private IPermission iUserPermission;
    private ArrayList<UserInterface> userInterfaces;
    private ArrayList<Action> actions;
    private ArrayList<Param> listOfOperations;

    private MCExtension(MCExtensionBuilder builder) {
        title = builder.title;
        summary = builder.summary;
        description = builder.description;
        version = builder.version;
        packageName = builder.packageName;
        icon = builder.icon;
        listOfOperations = new ArrayList<>();

        //IConfigure
        iConfigure = builder.iConfigure;
        if (iConfigure != null) {
            listOfOperations.add(new Param(IConfigure.TYPE, IConfigure.ID_GET_STATE, null, null));
            listOfOperations.add(new Param(IConfigure.TYPE, IConfigure.ID_SET, null, null));
        }

        //IBackgroundProcess
        iBackgroundProcess = builder.iBackgroundProcess;
        if (iBackgroundProcess != null) {
            listOfOperations.add(new Param(IBackgroundProcess.TYPE, IBackgroundProcess.ID_START, null, null));
            listOfOperations.add(new Param(IBackgroundProcess.TYPE, IBackgroundProcess.ID_STOP, null, null));
            listOfOperations.add(new Param(IBackgroundProcess.TYPE, IBackgroundProcess.ID_IS_RUNNING, null, null));
        }
        //IPermission
        iUserPermission = builder.iUserPermission;
        if (iUserPermission != null) {
            listOfOperations.add(new Param(IPermission.TYPE, IPermission.ID_HAS_PERMISSION, null, null));
            listOfOperations.add(new Param(IPermission.TYPE, IPermission.ID_REQUEST_PERMISSION, null, null));
        }
        //IUserInterface
        userInterfaces = builder.userInterfaces;
        for (int i = 0; userInterfaces != null && i < userInterfaces.size(); i++) {
            listOfOperations.add(userInterfaces.get(i).getParam());
        }
        //Action
        actions = builder.actions;
        for (int i = 0; actions != null && i < actions.size(); i++) {
            listOfOperations.add(actions.get(i).getParam());
        }
    }

    protected MCExtension(Parcel in) {
        title = in.readString();
        summary = in.readString();
        description = in.readString();
        version = in.readString();
        packageName = in.readString();
        icon = in.readParcelable(getClass().getClassLoader());
        listOfOperations = in.readArrayList(null);
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(summary);
        parcel.writeString(description);
        parcel.writeString(version);
        parcel.writeString(packageName);
        parcel.writeParcelable(icon, i);
        parcel.writeList(listOfOperations);
    }

    public static final Creator<MCExtension> CREATOR = new Creator<MCExtension>() {
        @Override
        public MCExtension createFromParcel(Parcel in) {
            return new MCExtension(in);
        }

        @Override
        public MCExtension[] newArray(int size) {
            return new MCExtension[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return version;
    }

    public String getPackageName() {
        return packageName;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public IConfigure getiConfigure() {
        return iConfigure;
    }

    public IBackgroundProcess getiBackgroundProcess() {
        return iBackgroundProcess;
    }

    public IPermission getiUserPermission() {
        return iUserPermission;
    }

    public ArrayList<UserInterface> getUserInterfaces() {
        return userInterfaces;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public ArrayList<Param> getUIParams() {
        ArrayList<Param> uiParams = new ArrayList<>();
        for (int i = 0; userInterfaces != null && i < userInterfaces.size(); i++) {
            uiParams.add(userInterfaces.get(i).getParam());
        }
        return uiParams;
    }

    public static MCExtensionBuilder Builder(Context context) {
        return new MCExtensionBuilder(context);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static class MCExtensionBuilder {
        private String title;
        private String summary;
        private String description;
        private String version;
        private String packageName;
        private Bitmap icon;
        private IConfigure iConfigure;
        private IBackgroundProcess iBackgroundProcess;
        private IPermission iUserPermission;
        private ArrayList<UserInterface> userInterfaces;
        private ArrayList<Action> actions;

        MCExtensionBuilder(Context context) {
            title = context.getApplicationInfo().name;
            packageName = context.getPackageName();
            try {
                version = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                version = null;
            }
            try {
                Drawable d = context.getPackageManager().getApplicationIcon(packageName);
                if (d instanceof BitmapDrawable) {
                    icon = ((BitmapDrawable) d).getBitmap();
                } else {
                    icon = Bitmap.createBitmap(d.getIntrinsicWidth(), d.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                }
            } catch (PackageManager.NameNotFoundException e) {
                icon = null;
            }
            userInterfaces = new ArrayList<>();
            actions = new ArrayList<>();
        }

        public MCExtensionBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public MCExtensionBuilder setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public MCExtensionBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public MCExtensionBuilder setVersion(String version) {
            this.version = version;
            return this;
        }

        public MCExtensionBuilder setPackageName(String packageName) {
            this.packageName = packageName;
            return this;
        }

        public MCExtensionBuilder setIcon(Bitmap icon) {
            this.icon = icon;
            return this;
        }

        public MCExtensionBuilder setConfigureInterface(IConfigure iConfigure) {
            this.iConfigure = iConfigure;
            return this;
        }

        public MCExtensionBuilder setBackgroundProcessInterface(IBackgroundProcess iBackgroundProcess) {
            this.iBackgroundProcess = iBackgroundProcess;
            return this;
        }

        public MCExtensionBuilder setUserPermissionInterface(IPermission iUserPermission) {
            this.iUserPermission = iUserPermission;
            return this;
        }

        public MCExtensionBuilder addUserInterface(String id, String title, String summary, MCUserInterface mcUserInterface) {
            UserInterface userInterface = new UserInterface(id, title, summary, mcUserInterface);
            this.userInterfaces.add(userInterface);
            return this;
        }

        public MCExtensionBuilder addAction(String id, String title, String summary, MCAction mcAction) {
            Action action = new Action(id, title, summary, mcAction);
            this.actions.add(action);
            return this;
        }

        public MCExtension build() {
            return new MCExtension(this);
        }
    }

}

