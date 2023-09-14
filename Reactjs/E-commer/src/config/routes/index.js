import adminRouter from "./admin";
import userRouter from "./user";

const publicRouter = [userRouter];
const privateRouter = [adminRouter];
export { publicRouter, privateRouter };
