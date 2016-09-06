package hello.classsystem;

import hello.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/paike/{school}")
public class SubjectController {

    @RequestMapping(value = "addgrade", produces = {"application/json"})
    public Result addGrade(@PathVariable("school") String school, @RequestParam HashMap<String, Object> params) {
        FakeKeeper.Keeper keeper = FakeKeeper.getInstance().getKeeper(school);
        String gradeName = (String) params.get("grade");
        Integer num = (Integer) params.get("num");
        if(gradeName == null && num == null) {
            return new Result(Result.STATUS_ERROR, Result.MSG_ERROR, null);
        }
        keeper.addGrade(gradeName, num);
        return new Result(Result.STATUS_SUCCESS, Result.MSG_SUCCESS, keeper.getGrades());
    }

    @RequestMapping(value = "deletegrade", produces = {"application/json"})
    public Result deleteGrade(@PathVariable("school") String school, @RequestParam HashMap<String, Object> params) {
        FakeKeeper.Keeper keeper = FakeKeeper.getInstance().getKeeper(school);
        String gradeName = (String) params.get("grade");

        if(gradeName == null) {
            return new Result(Result.STATUS_ERROR, Result.MSG_ERROR, null);
        }
        keeper.deleteGrade(gradeName);
        return new Result(Result.STATUS_SUCCESS, Result.MSG_SUCCESS, keeper.getGrades());
    }
}