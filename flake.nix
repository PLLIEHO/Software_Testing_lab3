{
  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs?rev=8cfef6986adfb599ba379ae53c9f5631ecd2fd9c";
  };

  outputs = { self, nixpkgs }:
    let pkgs = nixpkgs.legacyPackages.x86_64-linux;

    in {
      devShell.x86_64-linux = pkgs.mkShell {
        buildInputs = with pkgs; [ geckodriver chromedriver ];
      };
    };
}
