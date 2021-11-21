package com.example.moreapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MoreAppConfig {
    private static List<MoreAppModel> moreAppConfigs;

    public static List<MoreAppModel> getMoreAppConfigs() {
        return moreAppConfigs;
    }

    public static void setMoreAppConfigs(String data) {
        List<MoreAppModel> moreAppModels = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                List<String> images = new ArrayList<>();
                JSONArray ar = jsonObject.getJSONArray("appImages");
                for (int j = 0; j < ar.length(); j++) {
                    images.add(ar.getString(j));
                }
                String imgLogo, packageName, body, name;
                imgLogo = jsonObject.getString("appThumbnail");
                packageName = jsonObject.getString("packageName");
                body = jsonObject.getString("appDes");
                name = jsonObject.getString("appName");
                MoreAppModel model = new MoreAppModel(name, imgLogo, packageName, body, images);
                moreAppModels.add(model);
            }
            MoreAppConfig.moreAppConfigs = moreAppModels;
        } catch (JSONException e) {
            e.printStackTrace();
            MoreAppConfig.moreAppConfigs = null;
        }
    }

    public static class MoreAppModel {
        String name, packageName, title, logoApp;
        List<String> imagesLink;

        public MoreAppModel(String name, String logoApp, String packageName, String title, List<String> imagesLink) {
            this.name = name;
            this.packageName = packageName;
            this.title = title;
            this.imagesLink = imagesLink;
            this.logoApp = logoApp;
        }

        public String getLogoApp() {
            return logoApp;
        }

        public void setLogoApp(String logoApp) {
            this.logoApp = logoApp;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImagesLink() {
            return imagesLink;
        }

        public void setImagesLink(List<String> imagesLink) {
            this.imagesLink = imagesLink;
        }
    }
}
