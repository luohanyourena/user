package com.letter.user.utils;


import com.letter.user.enums.ResultEnum;
import com.letter.user.vo.ResultVO;

public class ResultVoUtil {
    public static ResultVO seccuss(ResultEnum resultEnum){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());
        resultVO.setData(null);
        return resultVO;
    }

    public static ResultVO seccuss(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("登陆成功");
        resultVO.setData(null);
        return resultVO;
    }

    public static ResultVO erro(ResultEnum resultEnum){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());
        resultVO.setData(null);
        return resultVO;
    }
}
