const Icon = (props) => {
  const { children } = props;
  return (
    <>
      <i
        class={children}
        style={{ color: "black", paddingTop: "5px", fontSize: "20px" }}
      ></i>
    </>
  );
};

export default Icon;
