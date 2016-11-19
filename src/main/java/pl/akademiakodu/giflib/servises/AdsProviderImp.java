package pl.akademiakodu.giflib.servises;

import org.springframework.beans.factory.annotation.Autowired;
import pl.akademiakodu.giflib.Reposytory.AdsProviderReposytory;
import pl.akademiakodu.giflib.model.AdverLisementProvider;

import java.util.List;

/**
 * Created by Camillo on 19.11.2016.
 */
public class AdsProviderImp implements AdsProviderServises{
    @Autowired
    private AdsProviderReposytory Provaider;
    @Override
    public List<AdverLisementProvider> finalAll() {
        return Provaider.finalAll();
    }
}
