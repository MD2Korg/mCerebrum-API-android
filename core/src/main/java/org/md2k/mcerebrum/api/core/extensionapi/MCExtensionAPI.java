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

package org.md2k.mcerebrum.api.core.extensionapi;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class MCExtensionAPI implements Parcelable
        , IMCExtensionBuilder.IPackageName
        , IMCExtensionBuilder.IName
        , IMCExtensionBuilder.IDescription
        , IMCExtensionBuilder.IVersion
        , IMCExtensionBuilder.IIcon
        , IMCExtensionBuilder.IOperation {
    private String packageName;
    private String name;
    private String description;
    private String version;
    private Bitmap icon;
    private IConfigure iConfigure;
    private IBackgroundProcess iBackgroundProcess;
    private IPermission iUserPermission;
    private ArrayList<UserInterface> userInterfaces;
    private ArrayList<Action> actions;
    private ArrayList<Param> listOfOperations;

    private MCExtensionAPI() {
        userInterfaces = new ArrayList<>();
        actions = new ArrayList<>();
    }

    protected MCExtensionAPI(Parcel in) {
        name = in.readString();
        description = in.readString();
        version = in.readString();
        packageName = in.readString();
        icon = in.readParcelable(getClass().getClassLoader());
        listOfOperations = in.readArrayList(null);
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(version);
        parcel.writeString(packageName);
        parcel.writeParcelable(icon, i);
        parcel.writeList(listOfOperations);
    }

    public static final Creator<MCExtensionAPI> CREATOR = new Creator<MCExtensionAPI>() {
        @Override
        public MCExtensionAPI createFromParcel(Parcel in) {
            return new MCExtensionAPI(in);
        }

        @Override
        public MCExtensionAPI[] newArray(int size) {
            return new MCExtensionAPI[size];
        }
    };

    public String getName() {
        return name;
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

    public static IMCExtensionBuilder.IPackageName builder() {
        return new MCExtensionAPI();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public IMCExtensionBuilder.IName setPackageName(String packageName) {
        this.packageName = packageName;
        return this;
    }

    @Override
    public IMCExtensionBuilder.IVersion setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public IMCExtensionBuilder.IOperation setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public IMCExtensionBuilder.IIcon setVersion(String version) {
        this.version = version;
        return this;
    }

    @Override
    public IMCExtensionBuilder.IDescription setIcon(Bitmap icon) {
        this.icon = icon;
        return this;
    }

    @Override
    public IMCExtensionBuilder.IOperation setConfigurationInterface(IConfigure iConfigure) {
        this.iConfigure = iConfigure;
        return this;
    }

    @Override
    public IMCExtensionBuilder.IOperation setPermissionInterface(IPermission iPermission) {
        this.iUserPermission = iPermission;
        return this;
    }

    @Override
    public IMCExtensionBuilder.IOperation setBackgroundExecutionInterface(IBackgroundProcess iBackgroundProcess) {
        this.iBackgroundProcess = iBackgroundProcess;
        return this;
    }

    @Override
    public IMCExtensionBuilder.IOperation addUserInterface(String id, String name, String description, MCUserInterface mcUserInterface) {
        UserInterface userInterface = new UserInterface(id, name, description, mcUserInterface);
        this.userInterfaces.add(userInterface);
        return this;
    }

    @Override
    public IMCExtensionBuilder.IOperation addAction(String id, String name, String description, MCAction mcAction) {
        Action action = new Action(id, name, description, mcAction);
        this.actions.add(action);
        return this;
    }

    @Override
    public MCExtensionAPI build() {
        createList();
        return this;
    }

    private void createList() {
        listOfOperations = new ArrayList<>();
        if (iConfigure != null) {
            listOfOperations.add(new Param(IConfigure.TYPE, IConfigure.ID_GET_STATE, "Configuration Status", null));
            listOfOperations.add(new Param(IConfigure.TYPE, IConfigure.ID_SET, "Set Configuration", null));
        }
        if (iBackgroundProcess != null) {
            listOfOperations.add(new Param(IBackgroundProcess.TYPE, IBackgroundProcess.ID_START, "Start Process", null));
            listOfOperations.add(new Param(IBackgroundProcess.TYPE, IBackgroundProcess.ID_STOP, "Stop Process", null));
            listOfOperations.add(new Param(IBackgroundProcess.TYPE, IBackgroundProcess.ID_IS_RUNNING, "Process Status", null));
        }
        if (iUserPermission != null) {
            listOfOperations.add(new Param(IPermission.TYPE, IPermission.ID_HAS_PERMISSION, "Permission Status", null));
            listOfOperations.add(new Param(IPermission.TYPE, IPermission.ID_REQUEST_PERMISSION, "Request Permission", null));
        }
        for (int i = 0; userInterfaces != null && i < userInterfaces.size(); i++) {
            listOfOperations.add(userInterfaces.get(i).getParam());
        }
        for (int i = 0; actions != null && i < actions.size(); i++) {
            listOfOperations.add(actions.get(i).getParam());
        }
    }

/*
    public static class MCExtensionBuilder {
        private String name;
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
            name = context.getApplicationInfo().name;
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

        public MCExtensionBuilder setName(String name) {
            this.name = name;
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
*/

}

