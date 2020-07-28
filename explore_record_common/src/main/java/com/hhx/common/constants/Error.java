package com.hhx.common.constants;

/**
 * 错误码定义规则（XX XXX），百位以下为模块错误码，百位以上为模块码
 */
public enum Error {

    /**
     * 通用错误
     */
    //参数校验错误
    VALIDATION_ERROR(1000),
    //未授权用户
    UNAUTHORIZED_USER(1001),
    //拒绝访问
    ACCESS_DENIED(1003),
    //未知错误
    UNKNOWN_ERROR(1004),
    //参数为空
    EMPTY_PARAMS_ERROR(1005),

    /**
     * 登记模块
     */
    //未匹配的密钥
    INVALID_KEY(2000),
    //身份证格式错误
    IDCARD_FORMAT_ERROR(2001),

    /**
     * 其他模块
     */
    //名称已存在
    DUPLICATION_NAME(3000),
    //工号已存在
    DUPLICATION_CODE(3001),
    //手机号已存在
    DUPLICATION_PHONE(3002),
    //医疗机构名称已存在
    DUPLICATION_HOSPITAL_NAME(3003),
    //医疗机构编码已存在
    DUPLICATION_HOSPITAL_CODE(3004),
    //设备编码已存在
    DUPLICATION_DEVICE_NO(3005),
    //设备已绑定诊室
    DEVICE_BINDING(3006),
    //设备AETITLE已经存在
    DUPLICATION_AETITLE(3007),
    //医院dicom标识已存在
    DUPLICATION_HOSPITAL_STATION_NAME(3009),

    /**
     * user-center
     */
    //密码错误
    ERROR_PASSWORD(4000),
    //原密码与新密码不能一样
    DUPLICATION_PASSWORD(4001),
    //禁用用户
    DISABLED_USER(4002),
    //禁止编辑管理员
    ADMIN_USER(4003),

    /**
     * 前置机
     */
    //找不到编码
    HOSPITAL_CODE_NOT_FOUND(5001),
    //不合法的修改
    INVALID_MODALITY(5002),
    //参数错误
    PARAM_ERROR(5003),

    /**
     * 诊断报告
     */
    //报告已锁定
    STUDY_LOCKED(6000),
    //未标记阴阳性不能打印
    UNMARKED_POSITIVE(6001),
    //检查参数缩写已存在
    DUPLICATION_ABBREVIATION(6002),

    /**
     * 病历管理
     */
    //检查VIP标记错误
    STUDY_VIP_ERROR(7001),
    //删除其他医生检查错误
    DELETE_OTHER_DOCTOR_STUDY_ERROR(7002),
    //删除打印后检查错误
    DELETE_PRINTED_STUDY_ERROR(7003),
    //检查被占用错误
    STUDY_OCCUPIED_ERROR(7004),
    //修改其他医生已打印的检查错误
    UPDATE_OTHER_DOCTOR_PRINTED_STUDY_ERROR(7005),
    //检查已被删除
    STUDY_IS_DELETED_ERROR(7006),

    /**
     * 华声云
     */
    INVALID_PHONE_NUMBER(8001),

    /**
     * 编程用户
     */
    //id未匹配到编程用户
    PROGRAMMING_ID_NOT_FOUND(9001),
    DELETE_PROGRAMMING_HOPSITAL_ERROR(9002),

    /**
     * 医疗机构
     */
    //创建医疗机构出错
    CREATE_HOSPITAL_ERROR(1101),
    //更新医疗机构信息时出错
    UPDATE_HOSPITAL_ERROR(1102),
    //医疗机构代码重复
    HOSPITAL_CODE_IS_EXIST(1103),
    //医疗机构名称重复
    HOSPITAL_NAME_IS_EXIST(1104),
    //医疗机构stationName重复
    HOSPITAL_STATION_NAME_IS_EXIST(1105),
    //id未匹配到医院
    HOSPITAL_ID_NOT_FOUND(1106),
    //更新logo错误
    UPDATE_HOSPITAL_LOGO_ERROR(1107),
    //更新基础信息状态错误
    UPDATE_HOSPITAL_BASE_HOSPITAL_STATUS_ERROR(1108),
    //写入基础数据错误
    PUT_BASE_DATA_ERROR(1109),
    //写入默认角色错误
    PUT_DEFAULT_ROLE_ERROR(1110),

    /**
     * 角色
     */
    //id未匹配到角色
    ROLE_ID_NOT_FOUND(1201),
    //默认角色已关联医院，无法修改和删除
    DEFAULT_ROLE_RELATED_HOSPITAL(1202),
    //创建角色失败
    CREATE_ROLE_ERRPR(1203),
    //添加角色医院关联失败
    ADD_ROLE_HOSPITAL_ERROR(1204),
    //删除角色医院关联失败
    DELETE_ROLE_HOSPITAL_ERROR(1205),
    //删除角色权限失败
    DELETE_ROLE_ACTION_ERROR(1206),
    //删除角色失败
    DELETE_ROLE_ERROR(1207),
    //医院角色已关联用户，无法删除
    HOSPITAL_ROLE_RELATED_USER(1208),
    //未找到医院和角色的关联
    HOSPITAL_ROLE_RELATED_NOT_FOUND(1209),
    //添加角色权限关联失败
    ADD_ROLE_ACTION_ERROR(1210),
    //角色名称已经存在
    ROLE_NAME_IS_EXIST(1211),
    //修改用户角色失败
    UPDATE_USER_ROLE_ERROR(1212),
    //删除角色用户失败
    DELETE_ROLE_USER_ERROR(1213),
    //无法修改管理员角色
    CANNOT_UPDATE_ADMIN_ROLE(1214),
    //无法删除管理员角色
    CANNOT_DELETE_ADMIN_ROLE(1215),
    //无法添加管理员用户
    CANNOT_ADD_ADMIN_USER(1216),
    //无法删除管理员用户
    CANNOT_DELETE_ADMIN_USER(1217),

    /**
     * 用户
     */
    //创建用户出错
    CREATE_USER_ERROR(1301),
    //更新用户名称出错
    UPDATE_USER_NAME_ERROR(1302),
    //更新用户电话号码出错
    UPDATE_USER_PHONE_ERROR(1303),
    //更新用户医院角色出错
    UPDATE_USER_HOSPITAL_ROLE_ERROR(1304),
    //id未匹配到用户
    USER_ID_NOT_FOUND(1305),
    //不可添加重复手机号码
    ADD_REPETITIVE_PHONE_ERROR(1306),
    //不可添加重复工号
    ADD_REPETITIVE_CODE_ERROR(1307),
    //未找到医院用户
    HOSPITAL_USER_NOT_FOUND(1308),
    //医院用户不可编辑
    HOSPITAL_USER_CANT_EDITABLE(1309),
    //医院已关联用户
    HOSPITAL_RELATED_USER_ERROR(1310),
    //用户的医院角色未找到
    USER_HOSPITAL_ROLE_NOT_FOUND(1311),

    /**
     * 报告模板
     */
    //报告模板名称重复
    ADD_REPETITIVE_REPORT_TEMPLATE_NAME(1401),
    //医院报告模板不存在
    HOSPITAL_REPORT_TEMPLATE_NOT_FOUND(1402),

    /**
     * 在线升级
     */
    //lastest文件上传失败
    LASTEST_UPLOAD_ERROR(1501),
    //blockmap文件上传失败
    BLOCAKMAP_UPLOAD_ERROR(1502),
    //setup文件上传失败
    SETUP_UPLOAD_ERROR(1503),
    //latest文件获取失败
    LATEST_GET_ERROR(1504),

    /**
     * 用户排序
     */
    //删除用户序号出错
    DELETE_USER_SERIAL_NUMBER_ERROR(1601),
    //添加用户序号出错
    ADD_USER_SERIAL_NUMBER_ERROR(1602),
    //医院没有其他用户
    HOSPITAL_NOT_HAVE_OTHER_USER(1603),


    ;

    private int code;

    Error(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
